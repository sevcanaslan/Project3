package com.bilgeadam.dao;


import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.entity.Admin;
import com.bilgeadam.entity.Customer;
import com.bilgeadam.entity.ProductEvaluate;

public class ProductEvaluateDao implements IRepository<ProductEvaluate>{

	@Override
	public void create(ProductEvaluate entity) {
		Session session = null;
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ProductEvaluate data is added to DB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding ProductEvaluate to DB");
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(long id) {
		
		Session session = null;
		try {
			ProductEvaluate deletedProductEvaluate = find(id);
			if (deletedProductEvaluate != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedProductEvaluate);
				session.getTransaction().commit();
				System.out.println("ProductEvaluate data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding ProductEvaluate to DB");
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<ProductEvaluate> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select productevaluate from ProductEvaluate as ProductEvaluate";
		TypedQuery<ProductEvaluate> typedQuery = session.createQuery(query, ProductEvaluate.class);
		List<ProductEvaluate> productEvaluateList = typedQuery.getResultList();
		productEvaluateList.forEach(System.out::println);
		return productEvaluateList;
	}

	@Override
	public ProductEvaluate find(long id) {
		Session session = dataBaseConnectionHibernate();
		ProductEvaluate productevaluate;
		try {
			productevaluate = session.find(ProductEvaluate.class, id);
			if (productevaluate != null) {
				System.out.println("ProductEvaluate Found--> " + productevaluate);
				return productevaluate;
			} else {
				System.out.println("ProductEvaluate not found");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while adding ProductEvaluate to DB");
		} finally {
			session.close();
		}
		return null;
	}

	public ProductEvaluate findById(long id) {
		Session session = dataBaseConnectionHibernate();
		ProductEvaluate productEvaluate;
		try {
			productEvaluate = session.find(ProductEvaluate.class, id);
			if(productEvaluate!= null) {
				System.out.println("ProductEvaluate found --> " + productEvaluate.getId() + " " + productEvaluate.getComment());
				return productEvaluate;
			}else {
				System.out.println("ProductEvaluate not found");
				return null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while finding ProductEvaluate");
		}
		return null;
	}

}
