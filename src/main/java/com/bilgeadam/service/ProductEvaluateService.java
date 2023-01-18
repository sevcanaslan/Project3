package com.bilgeadam.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.bilgeadam.dao.ProductEvaluateDao;
import com.bilgeadam.entity.Product;
import com.bilgeadam.entity.ProductEvaluate;

public class ProductEvaluateService implements IService<ProductEvaluate> {
	private ProductEvaluateDao productEvaluateDao;

	public ProductEvaluateService() {

		this.productEvaluateDao = new ProductEvaluateDao();
	}

	@Override
	public void create(ProductEvaluate entity) {
		productEvaluateDao.create(entity);
		
	}

	@Override
	public void delete(long id) {
		productEvaluateDao.delete(id);
		
	}

	@Override
	public List<ProductEvaluate> listAll() {
	
		return productEvaluateDao.listAll();
	}


	
	public ProductEvaluate findById(long id) {
		ProductEvaluate productEvaluate = productEvaluateDao.findById(id);
		return productEvaluate;
	}

	@Override
	public ProductEvaluate find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}
