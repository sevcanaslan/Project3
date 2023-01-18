package com.bilgeadam.service;

import java.util.List;

import com.bilgeadam.dao.UserDao;
import com.bilgeadam.entity.User;

public class UserService implements IService<User> {
	
	private UserDao userDao;
	
	
	
	
	public UserService() {
		this.userDao = new UserDao();
	}

	@Override
	public void create(User entity) {
		userDao.create(entity);
		
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
		
	}

	@Override
	public List<User> listAll() {
		
		return userDao.listAll();
	}

	@Override
	public User find(long id) {
		User user= userDao.find(id);
		return user;
	}

}
