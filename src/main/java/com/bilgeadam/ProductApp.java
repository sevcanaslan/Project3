package com.bilgeadam;

import com.bilgeadam.entity.Category;
import com.bilgeadam.entity.Product;
import com.bilgeadam.service.CategoryService;
import com.bilgeadam.service.ProductService;
import com.bilgeadam.util.ProductSystemMenu;

public class ProductApp {
	
	
	public static void main(String[] args) {
		ProductSystemMenu menu = new ProductSystemMenu();
		
		menu.menu();
	
	}

}
