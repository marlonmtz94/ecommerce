package com.marlon.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.marlon.model.Addresses; 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user")
@Table(name="user")
public class User {
	// these will be the column names used on the table 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="userid", unique= true)
	private int userid;
	@Column(name="email", unique=true)
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="phone")
	private String phone;	
	@Column(name= "permission")
	private String permission; 
	
	
	@OneToMany(mappedBy="user", cascade = CascadeType.PERSIST)
	private Set<userroles> usersrole = new HashSet<>(); 

}
