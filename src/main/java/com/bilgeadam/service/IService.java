package com.bilgeadam.service;
import java.util.List;
public interface  IService <T>{
	public void create(T entity);

	public void delete(long id);



	public List<T> listAll();

	public T find(long id);

}
