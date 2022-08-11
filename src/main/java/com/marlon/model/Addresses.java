package com.marlon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="address")
public class Addresses {
	// these will be the column names used on the table 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int AddressID;
	private int UserID; 
	private String Street;
	private String Unit;
	private String City;
	private String State;
	private int Zipcode; 
	private String Country;
	private String Phone; 
	

}
