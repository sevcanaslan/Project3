package com.bilgeadam.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import com.bilgeadam.entity.Customer;

public class CustomerDao implements IRepository<Customer> {

	@Override
	public void create(Customer entity) {
		Session session = null;
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Customer data is added to DB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Customer to DB");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Customer deletedCustomer = find(id);
			if (deletedCustomer != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedCustomer);
				session.getTransaction().commit();
				System.out.println("Customer data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Customer to DB");
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Customer> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select customer from Customer as customer";
		TypedQuery<Customer> typedQuery = session.createQuery (query, Customer.class);
		List<Customer> customerList = typedQuery.getResultList();
		for (int i = 0; i < customerList.size(); i++) {
			System.out.println("Customer id= " + customerList.get(i).getId() +  ", Identity=" + customerList.get(i).getIdentity() 
					+ ", FirstName= " + customerList.get(i).getFirstName() + ", LastName= " + customerList.get(i).getLastName() 
					+ ", Email= " + customerList.get(i).getEmail() + ", Password= " + customerList.get(i).getPassword());
		}
		return customerList;

	}

	@Override
	public Customer find(long id) {
		Session session = dataBaseConnectionHibernate();
		Customer customer;
		try {
			customer = session.find(Customer.class, id);
			if (customer != null) {
				System.out.println("customer Found--> " + customer);
				return customer;
			} else {
				System.out.println("customer not found");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while adding customer to DB");
		} finally {
			session.close();
		}
		return null;
	}
	
	public Optional<Customer> findByUserName(String username) {
		Session session = dataBaseConnectionHibernate();
		Customer customer = null;
		String hql = "select customer from Customer as customer where customer.identity =:key ";
		Query query = session.createQuery(hql);
		query.setParameter("key", username);
		try {
			customer = (Customer) query.getSingleResult();
			return Optional.of(customer);
		} catch (Exception e) {
			return Optional.empty();

		}
	}
	
	

}
