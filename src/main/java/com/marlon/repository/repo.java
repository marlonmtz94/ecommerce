package com.marlon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marlon.model.User; 

public interface repo extends JpaRepository<User, Integer>{
	
	

}
