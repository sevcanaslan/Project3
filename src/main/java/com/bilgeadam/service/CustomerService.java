package com.bilgeadam.service;

import java.util.List;
import java.util.Optional;

import com.bilgeadam.dao.CustomerDao;
import com.bilgeadam.entity.Customer;

public class CustomerService implements IService<Customer> {
	
	private CustomerDao customerDao;
	
	
	public CustomerService() {
		this.customerDao= new CustomerDao();
	}
	
	@Override
	public void create(Customer entity) {
		customerDao.create(entity);
	}

	@Override
	public void delete(long id) {
		customerDao.delete(id);
		
	}

	@Override
	public List<Customer> listAll() {
		
		return customerDao.listAll();
	}

	@Override
	public Customer find(long id) {
		Customer customer= customerDao.find(id);
		return customer;
	}
	
	public Optional<Customer> findByUserName(String username) {
		return customerDao.findByUserName(username);
	}

}
