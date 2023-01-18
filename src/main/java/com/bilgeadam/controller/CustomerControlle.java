package com.bilgeadam.controller;

import java.util.Optional;

import com.bilgeadam.entity.Customer;
import com.bilgeadam.entity.Product;
import com.bilgeadam.service.CustomerService;
import com.bilgeadam.service.ProductService;
import com.bilgeadam.util.BAUtils;

public class CustomerControlle {
	CustomerService customerService;
	ProductService productService;

	
	
	public CustomerControlle() {
	
		this.customerService =  new CustomerService();
		this.productService= new ProductService();
	}

	public void create() {
		String isim = BAUtils.readString("Lütfen isminizi giriniz: ");
		String soyisim = BAUtils.readString("Lütfen soy isminizi giriniz: ");
		String email = BAUtils.readString("Lütfen email adresinizi giriniz: ");
		String tc = BAUtils.readString("Lütfen tc kimlik numaranızı giriniz: ");
		String password = BAUtils.readString("Lütfen belirlediğiniz kullanıcı şifresini giriniz: ");
		Customer customer = new Customer(tc, password);
		customer.setEmail(email);
		customer.setFirstName(isim);
		customer.setLastName(soyisim);
		customerService.create(customer);
	}

	public void listAll() {
		customerService.listAll().forEach(customer-> System.out.println(customer));
	}
	
	public Optional<Customer> findByUserName(String username){
		return customerService.findByUserName(username);
	}

	public void buy(Customer customer) {
		int productid = BAUtils.readInt("Almak istediğiniz ürünün idsini giriniz");
		int adet = BAUtils.readInt("Kaç adet almak istediğinizi giriniz");
		Product buyproduct=productService.find(productid);
		buyproduct.setStock(buyproduct.getStock()-adet);
		customer.getProductList().add(buyproduct);
		productService.update(productid, buyproduct);

	}
	
	
	

}
