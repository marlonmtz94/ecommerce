package com.marlon.model;

import javax.persistence.Column;
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
@Table(name="product")
public class Product {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="ProductID")
	private int ProductID;
	@Column(name="ProductName")
	private String ProductName; 
	@Column(name="ColorID")
	private int ColorID;
	@Column(name="ProductPrice")
	private int ProductPrice; 
	@Column(name="QualityOnHands")
	private int QualityOnHands; 
	@Column(name="CategoryID", unique =true)
	private int CategoryID; 
	
	
	
	
}
