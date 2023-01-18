package com.bilgeadam.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bilgeadam.entity.Category;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.entity.Product;
import com.bilgeadam.entity.ProductEvaluate;
import com.bilgeadam.service.CategoryService;
import com.bilgeadam.service.ProductEvaluateService;
import com.bilgeadam.service.ProductService;
import com.bilgeadam.util.BAUtils;

public class ProductController {
	ProductService productService;
	CategoryService categoryService;
	ProductEvaluateService evaluateService;
	
	

	
	
	public ProductController() {
		this.productService= new ProductService();
		this.categoryService= new CategoryService();
		this.evaluateService= new ProductEvaluateService();
	}
	
	public void createProduct() {

		Product product= new Product();
		String title = BAUtils.readString("Lütfen product ismini giriniz");
		product.setProductName(title);
		
		Double price = BAUtils.readDouble("Lütfen ürünün fiyatını giriniz!");
		product.setPrice(price);
		
		int stock = BAUtils.readInt("Lütfen ürünün stok bilgisini giriniz!");
		product.setStock(stock);
		
		Long categoriID = (long) BAUtils.readInt("Lütfen product categorisinin ID'sini giriniz");
		Category category= categoryService.find(categoriID);
		product.setCategory(category);
		
		productService.create(product);
		
	}
	public void delete() {
		long id= BAUtils.readInt("Lütfen silmek istediğiniz ürünün ID sini giriniz: ");
		productService.delete(id);
	}
	
	public void listAll() {
		productService.listAll().forEach(product-> System.out.println(product));
	}
	
	public void listtukenenUrunler() {
		productService.listAll().stream()
		.filter(urun-> urun.getStock() <10)
		.forEach(urun-> System.out.println(urun));
	}
	
	public void yorumPuan(Customer customer) {
	
			long id = BAUtils.readLong("Please enter product id that you want to comment: ");
			int point = BAUtils.readInt("Please enter the point ");
			String comment = BAUtils.readString("Please enter comment for this product: ");
			Product yorumUrun=productService.find(id);
			ProductEvaluate procutE= new ProductEvaluate(comment,point,customer);
			customer.getProductEvaluates().add(procutE);
			evaluateService.create(procutE);
			
			


			

		
		
	}
	
	
	public void commentListByProducts(Customer customer) {
		long id = BAUtils.readLong("Please enter product id that you want to see all comments: ");
		evaluateService.findById(id);
		

	}
	
	
	
}
