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
@Table(name="payment")
public class Payment {
	// these will be the column names used on the table 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="UserID")
	private int UserID;
	@Column(name="PaymentType")
	private String PaymentType; 
	@Column(name="Provider")
	private String Provider; 
	@Column(name="CardNumber")
	private int CardNumber;
	@Column(name="Expiration")
	private int Expiration; 
	@Column(name="CCV")
	private int CCV; 
	
}
