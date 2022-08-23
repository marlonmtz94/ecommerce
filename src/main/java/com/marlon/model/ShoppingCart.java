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
@Entity
@Table(name="shoppingCart")
public class ShoppingCart {
	
	
	@Id @Column(name="cartid")
	private int cartid; 
	
	@Column(name="productId")
	private int productId; 
	
	@Column(name = "userid")
	private int userid; 
	
	@Column(name ="qty")
	private int qty; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product; 
	
	
	
}
