package com.marlon.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor 
@Component
public class EmailConfiguration {
	
	@Value("${smtp.mailtrap.io}")
	private String host;
	@Value("${smtp.mailtrap.port}")
	private int port;
	@Value("${smtp.mailtrap.username}")
	private String username; 
	@Value("${smtp.mailtrap.password}")
	private String password; 
	
	
	

}
