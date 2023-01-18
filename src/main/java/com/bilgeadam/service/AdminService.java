package com.bilgeadam.service;

import java.util.List;

import com.bilgeadam.dao.AdminDao;
import com.bilgeadam.entity.Admin;

public class AdminService implements IService<Admin> {
	private AdminDao adminDao;
	
	

	public AdminService() {
		this.adminDao=new AdminDao();
	}
	

	@Override
	public void create(Admin entity) {
		adminDao.create(entity);
		
	}

	@Override
	public void delete(long id) {
		adminDao.delete(id);
		
	}


	@Override
	public List<Admin> listAll() {
		
		return adminDao.listAll();
	}

	@Override
	public Admin find(long id) {
		Admin admin= adminDao.find(id);
		return admin;
	}

}
