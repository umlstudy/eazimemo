package asia.sejong.web.eazimemo.springconfig.root;  

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import asia.sejong.web.eazimemo.springconfig.security.SecurityConfig;

@PropertySource(name="jdbc.properties", value="classpath:/META-INF/db/jdbc.properties")
@Configuration 
@EnableTransactionManagement
@Profile("dev")
@MapperScan("asia.sejong.web.eazimemo.mapper")
@ComponentScan(basePackages= {
		 "asia.sejong.web.eazimemo.service"
})
@Import({ SecurityConfig.class }) // MvcConfig 에 위치하면 에러남
public class DbConfig /*extends WebMvcConfigurationSupport*/ {  
	
	@Autowired
    private Environment env;
	
	//new ClassPathResource("db.properties")

	@Bean
	public BasicDataSource getDataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		basicDataSource.setUsername(env.getProperty("jdbc.username"));
		basicDataSource.setPassword(env.getProperty("jdbc.password"));
		basicDataSource.setUrl(env.getProperty("jdbc.url"));
		basicDataSource.setInitialSize(Integer.parseInt(env.getProperty("jdbc.initialSize")));
		basicDataSource.setMaxActive(Integer.parseInt(env.getProperty("jdbc.maxActive")));
		basicDataSource.setMaxIdle(Integer.parseInt(env.getProperty("jdbc.maxIdle")));
		basicDataSource.setMinIdle(Integer.parseInt(env.getProperty("jdbc.minIdle")));
		basicDataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(env.getProperty("jdbc.timeBetweenEvictionRunsMillis")));
		basicDataSource.setValidationQuery(env.getProperty("jdbc.validationQuery"));
		basicDataSource.setTestOnBorrow(Boolean.getBoolean(env.getProperty("jdbc.testOnBorrow")));
		
		return basicDataSource;
	}
	
//	@SuppressWarnings("unchecked")
//	@Bean
//	public SimpleDriverDataSource getDataSource() {
//		
//		SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
//		try {
//			simpleDriverDataSource.setDriverClass((Class<Driver>)Class.forName(env.getProperty("jdbc.driverClassName")));
//			simpleDriverDataSource.setUsername(env.getProperty("jdbc.username"));
//			simpleDriverDataSource.setPassword(env.getProperty("jdbc.password"));
//			simpleDriverDataSource.setUrl(env.getProperty("jdbc.url"));
//			Properties prop = new Properties();
//			prop.setProperty("initialSize", env.getProperty("jdbc.initialSize"));
//			prop.setProperty("maxActive", env.getProperty("jdbc.maxActive"));
//			prop.setProperty("maxIdle", env.getProperty("jdbc.maxIdle"));
//			prop.setProperty("minIdle", env.getProperty("jdbc.minIdle"));
//			prop.setProperty("timeBetweenEvictionRunsMillis", env.getProperty("jdbc.timeBetweenEvictionRunsMillis"));
//			prop.setProperty("validationQuery", env.getProperty("jdbc.validationQuery"));
//			prop.setProperty("validationInterval", env.getProperty("jdbc.validationInterval"));
//			prop.setProperty("testOnBorrow", env.getProperty("jdbc.testOnBorrow"));
//			prop.setProperty("removeAbandoned", env.getProperty("jdbc.removeAbandoned"));
//			prop.setProperty("removeAbandonedTimeout", env.getProperty("jdbc.removeAbandonedTimeout"));
//			prop.setProperty("factory", env.getProperty("jdbc.factory"));
//			simpleDriverDataSource.setConnectionProperties(prop);
//		} catch ( ClassNotFoundException e ) {
//			throw new RuntimeException(e);
//		}
//		return simpleDriverDataSource;
//	}
	
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
 