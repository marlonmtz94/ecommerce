package com.marlon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marlon.model.User;
import com.marlon.model.userroles;
import com.marlon.repository.repo;

@Service 
public class usersService implements UserDetailsService {
	
	@Autowired
	repo repository; 
	

	public void login(String email, String password){
		
		System.out.println("THIS IS WHAT WE ARE GETTING: "+ repository.findlogin(email, password) ); 
		
		repository.findlogin(email, password); 
		
		System.out.println("wrong credentials: ");
			
		
		System.out.println("yaya ");
		 
		 
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
		 
		//lastID= repository.getLastid(); 
		
		//System.out.println("THE LAST ID IS: " + lastID);
		//role id should be set by default to 1 since 1 will be for users, 2 admin and 3 mods
		//userroles ur = new userroles();
		//ur.set(lastID+1);
		
		//use.getUsersrole().add(ur); 
		
		//System.out.println( "role id should be "+ ur.getRoleid()); 
		
		
		repository.save(use); 

	}
	
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        return user.map(GroupUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " Not Found"));
    }

}
