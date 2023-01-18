package com.bilgeadam.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.entity.Admin;
import com.bilgeadam.entity.User;

public class UserDao implements IRepository<User>{

	@Override
	public void create(User entity) {
		Session session = null;
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("User data is added to DB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding User to DB");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			User deletedUser = find(id);
			if (deletedUser != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedUser);
				session.getTransaction().commit();
				System.out.println("User data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding User to DB");
		} finally {
			session.close();
		}
	}

	@Override
	public List<User> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select user from User as user";
		TypedQuery<User> typedQuery = session.createQuery(query, User.class);
		List<User> userList = typedQuery.getResultList();
		userList.forEach(System.out::println);
		return userList;
	}

	@Override
	public User find(long id) {
		Session session = dataBaseConnectionHibernate();
		User user;
		try {
			user = session.find(User.class, id);
			if (user != null) {
				System.out.println("User Found--> " + user);
				return user;
			} else {
				System.out.println("User not found");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while adding User to DB");
		} finally {
			session.close();
		}
		return null;
	}

}
