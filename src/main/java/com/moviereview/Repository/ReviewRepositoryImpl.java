package com.moviereview.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.moviereview.Model.Review;
import com.moviereview.util.HibernateConfiguration;

public class ReviewRepositoryImpl implements ReviewRepository {

	@Override
	public List<Review> getReviewsByMovieId(int id) {
		Session s = null;
		Transaction tx = null;
		List<Review> reviews = new ArrayList<>();
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			
			reviews = s.createQuery("FROM Review WHERE movieID := id", Review.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return reviews;
	}

	@Override
	public List<Review> getReviewsByUserId(int id) {
		Session s = null;
		Transaction tx = null;
		List<Review> reviews = new ArrayList<>();
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			
			reviews = s.createQuery("FROM Review WHERE userID := id", Review.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return reviews;
	}

	@Override
	public void insertReview(Review review) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			
			s.save(review);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void updateReview(Review review) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s= HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			
			s.update(review);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
