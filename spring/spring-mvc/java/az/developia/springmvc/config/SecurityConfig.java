package az.developia.springmvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private DataSource ds;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.jdbcAuthentication().dataSource(ds);
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests() 
		.antMatchers(HttpMethod.GET, "/users/create-account").permitAll()
		.antMatchers(HttpMethod.GET, "/h2-console/**").permitAll()
		.antMatchers(HttpMethod.POST, "/users/save").permitAll()
		.antMatchers(HttpMethod.GET, "/css/**").permitAll()
		.antMatchers(HttpMethod.GET, "/js/**").permitAll()
		.antMatchers(HttpMethod.GET, "/imgs/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/my-login")
		.loginProcessingUrl("/authenticate-user").permitAll() ;
		
		http.headers().frameOptions().disable();

	}
	
	
	
}
