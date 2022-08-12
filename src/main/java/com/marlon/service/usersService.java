package com.marlon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marlon.model.User;
import com.marlon.model.userroles;
import com.marlon.repository.repo;

@Service 
public class usersService {
	
	@Autowired
	repo repository; 
	
	public void login(String email, String password){
		try {
		 //repository.findlogin(email, password); 
		 
		 System.out.println("Login success: ");
		 
		 
		}catch(Exception e) {
			System.out.println("Failed to Login: ");
		}
	}
	
	public List<User> getAllUsers(){
		
		return repository.findAll();
		
	}
	
	//used to handle the null pointer exceptions 
	public Optional<User> getUserbyId(int id){
		
		return repository.findById(id); 
	}
	
	
	
	
	public void deleteUser(Integer id ) {
		repository.deleteById(id);
		
	}
	
	public void addUser(User use) {
		
		int lastID; 
		 
		lastID= repository.getLastid(); 
		
		System.out.println("THE LAST ID IS: " + lastID);
		
		userroles ur = new userroles();
		ur.setRoleid(use.getUserid());
		
		use.getUsersrole().add(ur); 
		
		System.out.println( "role id should be "+ ur.getUser()); 
		
		
		//repository.save(use); 

	}

}
