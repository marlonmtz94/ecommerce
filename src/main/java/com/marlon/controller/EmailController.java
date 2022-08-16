package com.marlon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marlon.configuration.EmailConfiguration;

@RestController
@RequestMapping("/feedback")
public class EmailController {
	
	EmailConfiguration emconfi; 
	

}
