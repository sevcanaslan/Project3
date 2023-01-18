package com.bilgeadam.entity;

import java.util.ArrayList;
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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String productName;

	@Column
	private double price;

	@Column
	private int stock;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Customer customer;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name="product_evaluate", joinColumns = @JoinColumn(name="product_id"),
	inverseJoinColumns = @JoinColumn(name="product_evaluate_id"))
	private List<ProductEvaluate> productEvaluateList= new ArrayList<>();

	@ManyToOne(cascade = CascadeType.MERGE)
	private Category category;

	public Product() {

	}

	public Product(String productName, double price, int stock, Category category) {
		super();
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}

	public Product(String productName, double price, int stock, Customer customer, Category category) {
		super();
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.customer = customer;
		this.category = category;

	}

	@Override
	public String toString() {
	    return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", stock=" + stock + "]";
	}

}
