package com.bilgeadam.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String categoryName;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
	private List<Product> productList  = new ArrayList<>();;
	
	

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public Category() {
	
	}

	public Category(String categoryName, List<Product> productList) {
		super();
		this.categoryName = categoryName;
		this.productList = new ArrayList<>();
	}

	@Override
	public String toString() {
	    return "Category [id=" + id + ", categoryName=" + categoryName + "]";
	}

	


}
