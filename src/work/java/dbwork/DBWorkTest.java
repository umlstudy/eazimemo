package dbwork;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import asia.sejong.web.eazimemo.springconfig.root.DbConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DbConfig.class })
@WebAppConfiguration
@ActiveProfiles("dev")
public class DBWorkTest {

	final Logger logger = LoggerFactory.getLogger(DBWorkTest.class);

	@Autowired
	DataSource dataSource;

	@Test
	public void ds() throws Exception {
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		
		String databaseName = "eazimemo";

		// --- LISTING DATABASE SCHEMA NAMES ---
		ResultSet resultSet = conn.getMetaData().getCatalogs();

		while (resultSet.next()) {
			logger.info("Schema Name = " + resultSet.getString("TABLE_CAT"));
		}
		resultSet.close();

		// --- LISTING DATABASE TABLE NAMES ---
		String[] types = { "TABLE" };
		resultSet = conn.getMetaData().getTables(databaseName, null, "%", types);
		String tableName = "";
		while (resultSet.next()) {
			tableName = resultSet.getString(3);
			logger.info("Table Name = " + tableName);
			// --- LISTING DATABASE COLUMN NAMES ---
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet resultSet2 = meta.getColumns(databaseName, null, tableName, "%");

			while (resultSet2.next()) {
				logger.info("Column Name of table " + tableName + " = "
						+ resultSet2.getString(4));
				for ( int i=1;i<24;i++ ) {
					System.out.printf("%2d --> %s\n", i, resultSet2.getString(i));
				}
			}
			resultSet2.close();
		}
		resultSet.close();
	}
}