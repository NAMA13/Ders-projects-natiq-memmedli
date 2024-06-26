package az.developia.bookshopping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/create-account").permitAll()
                .antMatchers(HttpMethod.GET, "/customer").permitAll()
                .antMatchers(HttpMethod.GET, "/rest/books").permitAll()
                .antMatchers(HttpMethod.GET, "/styles/**").permitAll()
                .antMatchers(HttpMethod.GET, "/files/**").permitAll()
                .antMatchers(HttpMethod.GET, "/confirm-order").permitAll()
                .antMatchers(HttpMethod.POST, "/rest/orders").permitAll()
                .antMatchers(HttpMethod.POST, "/rest/books/search").permitAll()
                .antMatchers(HttpMethod.POST, "/order-confirmation-message").permitAll()
                .antMatchers(HttpMethod.POST, "/rest/orders/save-basket-books").permitAll()
                .antMatchers(HttpMethod.POST, "/confirm-order-process").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/show-login")
                .loginProcessingUrl("/authenticate-user")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

}
