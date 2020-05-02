package com.moviereview.Service;

import java.util.List;

import com.moviereview.Model.Review;
import com.moviereview.Repository.ReviewRepositoryImpl;

public class ReviewService {
	ReviewRepositoryImpl reviewRepository = new ReviewRepositoryImpl();
	
	public void newReview(Review review) {
		this.reviewRepository.insertReview(review);
	}
	
	public void updateReview(Review review) {
		this.reviewRepository.updateReview(review);
	}
	
	public List<Review> getReviewsByMovieId(int id) {
		return this.reviewRepository.getReviewsByMovieId(id);
	}
	
	public List<Review> getReviewsByUserId(int id) {
		return this.reviewRepository.getReviewsByUserId(id);
	}
	
	
}
