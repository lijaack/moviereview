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
//				sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
				sessionFactory = new Configuration().configure()						
						.setProperty("hibernate.connection.url", "jdbc:postgresql://movie-db.crr8wy1b38vr.us-west-1.rds.amazonaws.com/moviereview")
						.setProperty("hibernate.connection.username", "postgres")
						.setProperty("hibernate.connection.password", "password").buildSessionFactory();


			}
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}
