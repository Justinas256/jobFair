/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobFair.config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 *
 * @author justinas
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    DataSource dataSource;
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery(
         "select username,password, 'true' from users where username=?")
        .authoritiesByUsernameQuery(
         "select username, role from users where username=?");
    } 
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .antMatchers("/hello").access("hasRole('ADMIN')")  
        .anyRequest().permitAll()
        .and()
          .formLogin().loginPage("/login")
          .usernameParameter("username").passwordParameter("password")
         .and()
         .exceptionHandling().accessDeniedPage("/403")
        .and()
          .csrf();
    }
   
}
