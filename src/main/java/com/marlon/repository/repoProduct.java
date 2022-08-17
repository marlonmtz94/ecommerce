package com.marlon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marlon.model.Product; 

public interface repoProduct extends JpaRepository<Product, Integer>{
	

	Optional<Product> findById(int id); 
	


}
