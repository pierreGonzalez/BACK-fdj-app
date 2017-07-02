package com.springBootPackage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String USER = "USER";

	
	// Authentication : User --> Roles
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("pierre").password("youRawesome").roles(USER); 
	}
	// Authorization : Role -> Access
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.authorizeRequests()
				.antMatchers("fdj/public/*").permitAll()
				.anyRequest().authenticated()
				.antMatchers("fdj/private/*").hasRole(USER)
			.and().httpBasic();
	}
	
}
