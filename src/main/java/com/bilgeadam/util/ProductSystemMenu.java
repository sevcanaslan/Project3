package com.bilgeadam.util;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import com.bilgeadam.controller.CategoryController;
import com.bilgeadam.controller.CustomerControlle;
import com.bilgeadam.controller.ProductController;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.service.AdminService;
import com.bilgeadam.service.CategoryService;
import com.bilgeadam.service.CustomerService;
import com.bilgeadam.service.ProductEvaluateService;
import com.bilgeadam.service.ProductService;
import com.bilgeadam.service.UserService;

public class ProductSystemMenu {
	
	AdminService adminService;
	CategoryService categoryService;
	CustomerService customerService;
	ProductEvaluateService productEvaluateService;
	ProductService productService;
	UserService userService;
	ProductController productController;
	CustomerControlle customerController;
	CategoryController categoryController;
	
	
	public ProductSystemMenu() {
		super();
		this.categoryController= new CategoryController();
		this.productController = new ProductController();
		this.customerController = new CustomerControlle();
	}
	
	
	public void menu() {
		HashMap<Integer, String> menuItems = new HashMap<>();
		menuItems.put(1, "Admin");
		menuItems.put(2, "Customer Login");
		int key = BAUtils.menu(menuItems);
		switch (key) {
		case 1:
			// adminLogin
			adminMenu();
			break;
		case 2:
			customerMenu();
			break;

		default:
			break;
		
	}
}
	private void adminMenu() {
		HashMap<Integer, String> menuItems = new HashMap<>();
		menuItems.put(1, "Category Ekle");
		menuItems.put(2, "Product Ekle");
		menuItems.put(3, "Customerları Listele");
		menuItems.put(4, "Menuye dön");

		
		int key = BAUtils.menu(menuItems);

		switch (key) {
		case 1:
			categoryController.createCategory();
			break;
		case 2:
			productController.createProduct();
			break;
		case 3:
			customerController.listAll();
			break;
		case 4:
			menu();
			break;
		default:
			break;
		}
	}
	private void customerMenu() {
		HashMap<Integer, String> menuItems = new HashMap<>();
		menuItems.put(1, "Kayıt ol");
		menuItems.put(2, "Giriş yap");
		int key = BAUtils.menu(menuItems);

		switch (key) {
		case 1:
			customerController.create();
			break;
		case 2:
			CustomerLogin();
			break;
		default:
			break;
		}
	}
	

	private void customerMenu2(Customer customer) {
		HashMap<Integer, String> menuItems = new HashMap<>();
		menuItems.put(1, "Satın Al");
		menuItems.put(2, "Yorum yap");
		menuItems.put(3, "Stoğu bitmek üzere olan ürünler");
		menuItems.put(4, "Tüm ürünleri Listele");
		menuItems.put(5, "Ürünlere göre yorumları listele");
		menuItems.put(6, "Çıkış yap");


		
		int key = BAUtils.menu(menuItems);

		switch (key) {
		case 1:
			customerController.buy(customer);
			customerMenu2(customer);
			break;
		case 2:
			productController.yorumPuan(customer);
			break;
		case 3:
			productController.listtukenenUrunler();
			customerMenu2(customer);
			break;
		case 4:
			productController.listAll();
			customerMenu2(customer);
			break;
		case 5:
			productController.commentListByProducts(customer);
			break;
		case 6:
			System.out.println("Bye!");
			System.exit(1);
			
			break;
		default:
			break;
		}
	}
	

		private void CustomerLogin() {
		String username = BAUtils.readString("Lütfen username giriniz: ");
		String password = BAUtils.readString("Lütfen password giriniz: ");

		Optional<Customer> customer = customerController.findByUserName(username);
		
		if (customer.isPresent()) {
			if (customer.get().getPassword().equals(password)) {
				customerMenu2(customer.get());
			} else {
				System.out.println("Şifreyi kontrol edin");
			}
		} else {
			System.out.println("Username hatalı");
		}

	}
	
	
	
}
		
