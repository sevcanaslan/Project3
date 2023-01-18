package com.bilgeadam.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Customer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	private EUserType userType = EUserType.CUSTOMER;
	
	@Column
	private String identity;
	@Column
	private String password;
	
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Product> productList= new ArrayList<>();
	
	
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<ProductEvaluate> productEvaluates= new ArrayList<>();
	
	public Customer(String identity, String password) {
		super();
		this.identity = identity;
		this.password = password;
	}

	public Customer() {
	
	}

	@Override
	public String toString() {
	    return "Customer [id=" + id + ", userType=" + userType + ", identity=" + identity + ", password=" + password + "]";
	}


	
	


}
