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
@Table(name="orders")
public class Orders {
	// these will be the column names used on the table 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="OrderID", unique= true)
	private int OrderID;
	@Column(name="ProductID")
	private int ProductID; 
	@Column(name="OrderNumber")
	private int OrderNumber; 
	@Column(name="TotalPrice")
	private int TotalPrice; 
	@Column(name="TotalQuality")
	private int TotalQuality; 
	@Column(name="UserID")
	private int UserID; 
	@Column(name="AddressID")
	private int AddressID; 
	@Column(name="OrderStatus")
	private String OrderStatus; 
	
	
	
}
