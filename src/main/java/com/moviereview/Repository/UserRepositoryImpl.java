package com.moviereview.Repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.moviereview.Model.User;
import com.moviereview.util.HibernateConfiguration;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public User getUser(String username) {
		User user = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			user = s.createQuery("FROM users WHERE username = :username", User.class).setParameter("username", username).getSingleResult();
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

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

}
