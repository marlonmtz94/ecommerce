package com.marlon.controller;

//import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marlon.common.UserConstant;
import com.marlon.model.Login;
import com.marlon.model.Product;
import com.marlon.model.ProductCategory;
import com.marlon.model.User;
import com.marlon.service.usersService;
import com.marlon.service.productService;

@RestController // implementing restful web services
public class controller {
	
	@Autowired
	private usersService userserv; // has a relationship 
	@Autowired
	private productService productserv; 
	@Autowired
	private BCryptPasswordEncoder pwdEncoder; 
	
	@GetMapping("/listusers")
	public List<User> listAllUsers(){
		
		return userserv.getAllUsers(); 
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserId(@PathVariable Integer id){
		Optional<User> us = userserv.getUserbyId(id); 
		System.out.println("User selected is: " + us );
		return new ResponseEntity<User>(HttpStatus.OK); 
	}
	
	/*
	@GetMapping("/delete/{id}")
	public void getdeletebyId(@PathVariable Integer id)
	{
		
		System.out.println("Deleted a user by id: " + id); 
	}
	*/
	
	
	@PostMapping("/loginuser")
	public void loginUser(@RequestBody Login log) {
		
		System.out.println(" tHIS IS MY CREDENTIALS: " + log.getPassword());
		System.out.println("password:??? " );
		String passwords = pwdEncoder.encode(log.getPassword()); 
		
		System.out.println( "this is encoded: " + passwords);
		userserv.login(log.getEmail(),passwords); 		
		
	}
	
	
	
	//video 8-10 hour 1.50 
	
	@PostMapping("/adduser")
	public String addUser(@RequestBody User us) {
		System.out.println("Before adding the users they are these:  " + us);
		
		System.out.println("hash password to add to DB " + us.getPassword());

		us.setPermission(UserConstant.DEFAULT_ROLE); // user by default when creating an account 
		
		String encodedpwd = pwdEncoder.encode(us.getPassword()); 
			
		us.setPassword(encodedpwd); 
		
		System.out.println("encoded pass is now: " + us.getPassword());
		
		userserv.addUser(us);
		
		System.out.println("Once it successfully creates user send an email here.... ");
		//send mail after successful account creation 
		// emailSent(); 
		
		return "Welcome " + us.getFirst_name() + " to the user's website. "; 
		
		
	}
	
	@PostMapping("/addcategory")
	public String addProduct(@RequestBody ProductCategory cat) {
		
		System.out.println("these are the categories " + cat); 
		productserv.addCat(cat); 
		return "Added Categories";
	}
	
	
	@PostMapping("/addproducts")
	public String addProduct(@RequestBody Product pro) {
		
		System.out.println("These are my products: " + pro );
		
		productserv.addPro(pro);
		
		return "ADDED PRODUCTS "; 
		
	}
	
	

	@GetMapping("/getAllProducts")
	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> listallproducts(){
		System.out.println("Admin you retrived all the following products: ");
		
		return productserv.getAllProducts(); 
		
	}
	
	
	
	
	@GetMapping("/getAll")
	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<User> listallusers(){
		return userserv.getAllUsers(); 
		
	}
	
	@GetMapping("/")
	public String welcome() {
		
		return "Welcome to the home page "; 
		
	}
	
	@GetMapping("/user")
	@Secured("ROLE_USER")
	@PreAuthorize("hasAuthority('ROLE_USER')")
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
