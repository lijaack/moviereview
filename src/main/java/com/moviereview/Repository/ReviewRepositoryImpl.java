package com.moviereview.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.moviereview.Model.Review;
import com.moviereview.Model.User;
import com.moviereview.util.HibernateConfiguration;


@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

	@Override
	public List<Review> getReviewsByMovieId(String movieID) {
		Session s = null;
		Transaction tx = null;
		List<Review> reviews = new ArrayList<>();

		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			reviews = s.createQuery("FROM Review WHERE movieID = :movieID", Review.class).setParameter("movieID", movieID).getResultList();
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
			reviews = s.createQuery("FROM Review WHERE userID = :id", Review.class).setParameter("id", id).getResultList();
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
			User user = s.get(User.class, review.getUserID());
			user.add(review);
			s.save(user);
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
