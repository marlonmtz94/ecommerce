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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="productcategory")
@Table(name="productcategory")
public class ProductCategory {
	// these will be the column names used on the table 
	@Id  @Column(name="CategoryID")
	private int CategoryID;
	@Column(name="CategoryName")
	private String CategoryName; 
	
	/*
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "CategoryID", unique =true)
	private Product pro; 
	*/
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="CategoryID", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Product> product; 
	
}
