package com.moviereview.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.moviereview.Model.User;
import com.moviereview.util.HibernateConfiguration;

@Repository
public class UserRepositoryImpl implements UserRepository {

		
	@Override
	public void newUser(User user) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			s.save(user);
			tx.commit();
	
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}	
	}

	@Override
	public User getUser(String username) {
		User user = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			user = s.createQuery("FROM User WHERE username = :username", User.class).setParameter("username", username).getSingleResult();
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			users = s.createQuery("FROM User", User.class).getResultList();
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return users;
	}

	@Override
	public void updateUser(User user) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			s.update(user);
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
	}

	@Override
	public User userLogin(String username, String password) {
		User user = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			user = s.createQuery("FROM User WHERE username = :username and password =:password", User.class).setParameter("username", username).setParameter("password", password).getSingleResult();
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return user;
	}

	
}
