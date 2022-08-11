package com.marlon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marlon.model.User;
import com.marlon.repository.repo;

@Service 
public class usersService {
	
	@Autowired
	repo repository; 
	
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
		
		repository.save(use); 
	}

}
