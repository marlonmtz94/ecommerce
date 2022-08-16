package com.marlon.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.marlon.service.usersService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =true, securedEnabled =true)
public class config extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private usersService userserv; 
	
	@Override
	protected void configure( AuthenticationManagerBuilder auth ) throws Exception{
		
		auth.userDetailsService(userserv); 
		
		
	}
	
  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();//csrf->cross site request forgery
       // http.authorizeRequests().antMatchers("/user/join").permitAll().and().authorizeRequests()
       //         .antMatchers("/user/**","/post/**").authenticated().and().httpBasic();
        
        http.authorizeRequests().antMatchers("/user/getAll").hasRole("ADMIN").and().formLogin();        
        
    }
	
	
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable(); 
		http.authorizeRequests()
		.antMatchers("/admin").hasAnyRole("ADMIN", "USER")
		.antMatchers("/user").hasRole("USER")
		.antMatchers("/login").permitAll()
		.antMatchers("/adduser").permitAll()
		.and().formLogin(); 
		
		
	}
	*/
	
	@Bean
	public BCryptPasswordEncoder passwordEncouder() {
		
		return new BCryptPasswordEncoder(); 
	}

	
	
}
