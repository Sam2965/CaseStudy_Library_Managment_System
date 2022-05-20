package com.cg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cg.filter.JwtFilter;
//@Configuration : Tags the class as a source of bean definitions for the application context.
@Configuration
//The @EnableWebSecurity is a marker annotation. It allows Spring to find (it's a @Configuration and, therefore, @Component )
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//it is used to inject dependency
	@Autowired
	private JwtFilter jwtFilter;
	
	//it is used to inject dependency
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf()
		.disable()
		.authorizeRequests().antMatchers("/")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		
	}
	
	//it is used to inject dependency
	@Override
	
	//@Bean is a method-level annotation and a direct analog of the XML <bean/> element.
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
}
