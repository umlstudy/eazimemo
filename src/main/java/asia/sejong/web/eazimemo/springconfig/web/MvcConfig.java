package asia.sejong.web.eazimemo.springconfig.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableAspectJAutoProxy
@Profile("dev")
@ComponentScan(basePackages= {
		 "asia.sejong.web.eazimemo.web"
})
public class MvcConfig extends WebMvcConfigurationSupport {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/view/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}
	
//	@Bean
//	public InternalResourceViewResolver htmlViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/view/");
//		resolver.setSuffix(".html");
//		resolver.setOrder(0);
//		resolver.setViewNames(new String[] {"loginPage",});
//		
//		return resolver;
//	}
	
	/*
	@Bean
	public ContentNegotiationManager contentNegotiationManager() throws Exception {
		
		ContentNegotiationManagerFactoryBean bean = new ContentNegotiationManagerFactoryBean();
		
		Properties mediaTypes = new Properties();
		mediaTypes.put("json", MediaType.APPLICATION_JSON_VALUE);
		mediaTypes.put("xml", MediaType.APPLICATION_XML_VALUE);
		mediaTypes.put("rss", "application/rss+xml");
		mediaTypes.put("pdf", "application/pdf");
		
		bean.setMediaTypes(mediaTypes);
		bean.setIgnoreAcceptHeader(true);
		
		return bean.getObject();
	}
	*/
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}