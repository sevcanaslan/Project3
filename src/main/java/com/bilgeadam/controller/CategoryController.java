package com.bilgeadam.controller;

import com.bilgeadam.entity.Category;
import com.bilgeadam.entity.Product;
import com.bilgeadam.service.CategoryService;
import com.bilgeadam.util.BAUtils;

public class CategoryController {
	
CategoryService categoryService;


	
	public CategoryController() {
	
	this.categoryService = new CategoryService();
}



	public void createCategory() {
		Product product;

		String title = BAUtils.readString("Lütfen kategori ismini giriniz");
		Category  category = new Category();
		category.setCategoryName(title);
		categoryService.create(category);


	}

}
