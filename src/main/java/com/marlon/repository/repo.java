package com.marlon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marlon.model.User; 

public interface repo extends JpaRepository<User, Integer>{
	
	
	//@Query("Select email,password from user where email= (:email) and password= (:password)")
	//oid findlogin(@Param("email") String email, @Param("password") String password); 
	
	
	//Optional<User> findByEmail(String email); 
	
	@Query("SELECT userid FROM ecommerce.user ORDER BY userid DESC LIMIT 0, 1")
	Integer getLastid(); 
	

}
