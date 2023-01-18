package com.bilgeadam.service;

import java.util.List;

import com.bilgeadam.dao.ProductDao;
import com.bilgeadam.entity.Product;

public class ProductService implements IService<Product> {
	private ProductDao productDao;
	
	public ProductService() {
		this.productDao=new ProductDao();
	}

	@Override
	public void create(Product entity) {
		productDao.create(entity);
		
	}

	@Override
	public void delete(long id) {
		productDao.delete(id);
		
	}

	@Override
	public List<Product> listAll() {
	
		return productDao.listAll();
	}
	
	public void update(long id, Product entity) {
		productDao.update(id, entity);

	}
	@Override
	public Product find(long id) {
		Product product= productDao.find(id);
		return product;
	}

}
