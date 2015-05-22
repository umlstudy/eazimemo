package asia.sejong.web.eazimemo.springconfig.root;  

import java.io.IOException;
import java.sql.Driver;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@PropertySource(name="jdbc.properties", value="classpath:/META-INF/db/jdbc.properties")
@Configuration 
@EnableTransactionManagement
@Profile("dev")
@MapperScan("asia.sejong.web.eazimemo.mapper")
public class DbConfig extends WebMvcConfigurationSupport {  
	
	@Autowired
    private Environment env;

	@SuppressWarnings("unchecked")
	@Bean
	public SimpleDriverDataSource getDataSource() {
		
		SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
		try {
			simpleDriverDataSource.setDriverClass((Class<Driver>)Class.forName(env.getProperty("jdbc.driverClassName")));
			simpleDriverDataSource.setUsername(env.getProperty("jdbc.username"));
			simpleDriverDataSource.setPassword(env.getProperty("jdbc.password"));
			simpleDriverDataSource.setUrl(env.getProperty("jdbc.url"));
		} catch ( ClassNotFoundException e ) {
			throw new RuntimeException(e);
		}
		return simpleDriverDataSource;
	}
	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean getSqlSessionFactory(DataSource ds) {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(ds);
		
		bean.setTypeAliasesPackage("asia.sejong.web.eazimemo.domain");
		
		String searchingPackages = "classpath:/asia/sejong/web/eazimemo/mapper/**/*.xml";
		PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] resources = resourceResolver.getResources(searchingPackages);
			bean.setMapperLocations(resources);
			return bean;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}  
 