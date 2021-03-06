package com.moviereview.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.moviereview.Model.Admin;
import com.moviereview.util.HibernateConfiguration;

@Repository
public class AdminRepositoryImpl implements AdminRepository{

	@Override
	public void newAdmin(Admin admin) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			s.save(admin);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public Admin getAdmin(String username) {
		Admin admin = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			admin = s.createQuery("FROM Admin WHERE username = :username", Admin.class).setParameter("username", username).getSingleResult();
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return admin;

	}

	@Override
	public Admin adminLogin(String username, String password) {
		Admin admin = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			admin = s.createQuery("FROM Admin WHERE username = :username and password =:password", Admin.class).setParameter("username", username).setParameter("password", password).getSingleResult();
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return admin;
	}

	@Override
	public void updateAdmin(Admin admin) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			s.update(admin);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
	}

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> admins = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			admins = s.createQuery("FROM Admin", Admin.class).getResultList();
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return admins;

	}
	
}
