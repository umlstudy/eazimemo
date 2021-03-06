package asia.sejong.web.eazimemo.springconfig.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	//http://www.mkyong.com/spring-security/spring-security-form-login-using-database/
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
////		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//		
//		/* TODO IMSI
//		auth.jdbcAuthentication().dataSource(dataSource)
//			.usersByUsernameQuery(
//				"select userId as username, password, enabled from User where userId=? ")
//			.authoritiesByUsernameQuery(
//				" select u.userId username, concat('ROLE_', g.rolegroupid ) role " +
////				" select u.userId username,  g.rolegroupid role " +
//				" from user u, userrolegrouprel r, rolegroup g " +
//				" where u.userid = r.userid and r.roleGroupId=g.roleGroupId " + 
//				" and u.userid=?" );
//				*/
//	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
				"select userId as username, password, enabled from User where userId=? ")
			.authoritiesByUsernameQuery(
				" select u.userId username, concat('ROLE_', g.rolegroupid ) role " +
//				" select u.userId username,  g.rolegroupid role " +
				" from user u, userrolegrouprel r, rolegroup g " +
				" where u.userid = r.userid and r.roleGroupId=g.roleGroupId " + 
				" and u.userid=?" );
	}
	
//	@Bean 
//	@Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.authenticationProvider(new AuthenticationProvider() {
//			
//			@Override
//			public boolean supports(Class<?> authentication) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//			
//			@Override
//			public Authentication authenticate(Authentication authentication)
//					throws AuthenticationException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
//		http.authorizeRequests()
//			.antMatchers("/article/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//			.and().formLogin();
		
//		  http
//          .csrf().disable()
//          .formLogin()
//              .loginPage("/login")
//              .failureUrl("/login?login_error=1")
//              .defaultSuccessUrl("/home")
//              .and()
//          .logout()
//              .logoutUrl("/logout")
//              .logoutSuccessUrl("/index");
		//http.csrf().disable().formLogin();
		http.formLogin();
		http
			//.csrf().disable()
			.formLogin()
				.loginPage("/login/loginPage")
				.failureUrl("/login/loginPage?error")
				.loginProcessingUrl("/login/loginProcess")
	//			.usernameParameter("username")
	//			.passwordParameter("password")
				.defaultSuccessUrl("/welcome")
//				.and()
//			.logout()
	//			//.logoutUrl("/logout")
	//			.logoutSuccessUrl("/loginout/login?logout")
			;
	}
}
