package com.bilgeadam.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity

public class ProductEvaluate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String comment;

	@Column
	private int puan;

	@ManyToOne
	private Customer customer;
	
	
	@ManyToMany(mappedBy = "productEvaluateList", cascade = CascadeType.ALL)
	private List<Product> productList= new ArrayList<>();

	public ProductEvaluate() {

	}

	public ProductEvaluate(String comment, int puan, Customer customer) {
		super();
		this.comment = comment;
		this.puan = puan;

		this.customer = customer;
	}

	@Override
	public String toString() {
	    return "ProductEvaluate [id=" + id + ", comment=" + comment + ", puan=" + puan + "]";
	}
	
	

}
