package com.marlon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.marlon.model.Product;
import com.marlon.model.ProductCategory;
import com.marlon.repository.repoCategory;
import com.marlon.repository.repoProduct;

@Service
public class productService {
	
	@Autowired
	repoProduct repoProd; 
	@Autowired 
	repoCategory repoCat; 

	public List<Product> getAllProducts(){
		
		return repoProd.findAll(); 
		
		
	}
	
	public void addPro(Product use) {
		
		
		System.out.println("inside the product service and these are still prods?: " + use); 
		use = repoProd.save(use); 

	}
	
public void addCat(ProductCategory cate) {
		
		
		System.out.println("inside the product service and these are still prods?: " + cate); 
		repoCat.save(cate); 

	}
	
	
	
	

}
