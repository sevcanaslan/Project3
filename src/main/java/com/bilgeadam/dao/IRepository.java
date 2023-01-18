package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtils;

public interface IRepository<T>  {
	public void create(T entity);

	public void delete(long id);

	public List<T> listAll();

	public T find(long id);

	default Session dataBaseConnectionHibernate() {

		return HibernateUtils.getSessionFactory().openSession();
	}
}
