package com.marlon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	@PostMapping("/adduser")
	public void addUser(@RequestBody User us) {
		System.out.println("Before adding the users they are these:  " + us);
		userserv.addUser(us);
		
	}
	
	
	
	
	
	@GetMapping("/")
	public String welcome() {
		
		return "Welcome to the home page "; 
		
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