package dbwork;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import asia.sejong.web.eazimemo.springconfig.root.DbConfig;
import asia.sejong.web.eazimemo.util.ResourceUtil;
import asia.sejong.web.eazimemo.util.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DbConfig.class })
//@WebAppConfiguration
@ActiveProfiles("dev")
public class DBWorkCreateBeans {

	final Logger logger = LoggerFactory.getLogger(DBWorkCreateBeans.class);

	@Autowired
	DataSource dataSource;

	@Test
	public void ds() throws Exception {
		
		String databaseName = "eazimemo";
		String[] types = { "TABLE" };
		String tableName = "";
		String columnName = "";
		String columnType = "";
		String beanTemplate = JavaBeanTemplate.getBeanTemplate();
		String beanGSetterTemplate = JavaBeanTemplate.getBeanGSetterTemplate();
		StringBuilder propertiesPart = null;
		StringBuilder gsetterPart = null;
		
		Connection conn = dataSource.getConnection();
		ResultSet tableInfoResultSet = conn.getMetaData().getTables(databaseName, null, "%", types);
		while (tableInfoResultSet.next()) {
			propertiesPart = new StringBuilder();
			gsetterPart = new StringBuilder();
			tableName = tableInfoResultSet.getString(3);
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet columnInfoResultSet = meta.getColumns(databaseName, null, tableName, "%");
			while (columnInfoResultSet.next()) {
				columnName = columnInfoResultSet.getString(4);
				columnType = columnInfoResultSet.getString(6);
				columnType = DBWorkUtil.getTypeString(columnType);
				propertiesPart
					.append("private ")
					.append(columnType)
					.append(" ")
					.append(columnName)
					.append(";\n");
				gsetterPart
					.append(MessageFormat.format(beanGSetterTemplate, 
							columnName,
							columnType,
							StringUtil.toPascalCase(columnName)
							))
					.append("\n");
			}
			
			columnInfoResultSet.close();
			
			String createdBean = MessageFormat.format(beanTemplate, 
					"dbwork.rslt",
					StringUtil.toPascalCase(tableName),
					propertiesPart.toString(),
					gsetterPart.toString()
					);
			
			String filePath = "C:\\workspace\\transmate\\eazimemo\\src\\work\\java\\dbwork\\rslt";
			ResourceUtil.write(filePath, StringUtil.toPascalCase(tableName) + ".java", createdBean);
		}
		tableInfoResultSet.close();
	}
}