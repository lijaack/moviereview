package com.moviereview.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviereview.Model.Review;
import com.moviereview.Repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;
	
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