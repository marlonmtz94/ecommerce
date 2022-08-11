package com.marlon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.marlon.model.Addresses; 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
	// these will be the column names used on the table 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="userid")
	private int userid;
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	private String phone;	
	

	
	// has a relationship 
	//@Autowired 
	//private Addresses addr; 

}
