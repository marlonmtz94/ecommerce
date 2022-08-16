package com.marlon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marlon.model.User; 

public interface repo extends JpaRepository<User, Integer>{
	
	
	@Query("SELECT userid,email from user where email= :email and password= :password") 
	Optional<User> findlogin(@Param("email") String email, @Param("password") String password); 
	
	
	Optional<User> findByEmail(String email); 
	
	// this will get the max id in my database and will be used to add to the roles table role id 
	//@Query("SELECT max(userid) from user") 
	//public int getLastid(); 
	

}
