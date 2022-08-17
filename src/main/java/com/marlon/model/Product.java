package com.marlon.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="product")
@Table(name="product")
public class Product {
	
	@Id @Column(name="ProductID")
	private int ProductID;
	@Column(name="ProductName")
	private String ProductName; 
	@Column(name="ColorID")
	private int ColorID;
	@Column(name="ProductPrice")
	private int ProductPrice; 
	@Column(name="Qty")
	private int Qty; 	
	
	/*
	@OneToMany(mappedBy="pro", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<ProductCategory> productcategory = new HashSet<>(); 
	*/
	
	@JsonBackReference // still worked with out but ill keep it just in case 
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL) 
	@JoinColumn(name="CategoryID", referencedColumnName="CategoryID")
	private ProductCategory CategoryID; 
	
	
}
