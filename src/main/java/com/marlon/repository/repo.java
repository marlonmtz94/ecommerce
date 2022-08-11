package com.marlon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marlon.model.User; 

public interface repo extends JpaRepository<User, Integer>{
	
	
	//@Query("Select email,password from user where email= (:email) and password= (:password)")
	//void findlogin(@Param("email") String email, @Param("password") String password); 
	

}
