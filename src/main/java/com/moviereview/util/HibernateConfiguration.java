package com.moviereview.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
	private static SessionFactory sessionFactory;

	public static Session getSession() {
		try {
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
			}
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}
