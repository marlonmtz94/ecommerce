package com.marlon.controller;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marlon.model.User;
import com.marlon.service.usersService;

@RestController // implementing restful web services
public class controller {
	
	@Autowired
	private usersService userserv; // has a relationship 
	
	@GetMapping("/listusers")
	public List<User> listAllUsers(){
		
		return userserv.getAllUsers(); 
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserId(@PathVariable Integer id){
		Optional<User> us = userserv.getUserbyId(id); 
	
		return new ResponseEntity<User>(HttpStatus.OK); 
	}
	
	
	@PostMapping("/login")
	public void loginUser(@RequestBody String email, String pass) {
		
		System.out.println(email + pass);
		
		userserv.login(email, pass); 		
		
	}
	
	
	
	//video 8-10 hour 1.50 
	
	@PostMapping("/adduser")
	public void addUser(@RequestBody User us) {
		System.out.println("Before adding the users they are these:  " + us);
		
		System.out.println("hash password to add to DB " + us.getPassword());
		//BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder(5, new SecureRandom());
		
		//	String encodedpwd = bcpe.encode(us.getPassword()); 
			
		//	us.setPassword(encodedpwd); 
		
		
		System.out.println("encoded pass is now: " + us.getPassword());
		
		userserv.addUser(us);
		
		System.out.println("Once it successfully creates user send an email here.... ");
		//send mail after successful account creation 
		
	}
	
	
	
	
	
	@GetMapping("/")
	public String welcome() {
		
		return "Welcome to the home page "; 
		
	}
	
	@GetMapping("/user")
	public String welcomeuser() {
		
		return "Welcome to the home page of USer "; 
		
	}
	
	@GetMapping("/admin")
	public String welcomeadmin() {
		
		return "Welcome to the home page ADmin "; 
		
	}
	
	
	
	
	
	/*
	 * video of 8-5-22 
	 * @Autowired JdbcTemplate jdbc;
	 * @GetMapping("/insert")
	 * public String index() {
	 * 
	 * jdbc.execute("");
	 * 
	 * return "data inserted to db";
	 * 
	 * }
	 */
	
	
	

}
