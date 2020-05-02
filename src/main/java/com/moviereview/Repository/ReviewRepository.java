package com.moviereview.Repository;

import java.util.List;

import com.moviereview.Model.Review;
import com.moviereview.Model.User;

public interface ReviewRepository {
	public void newReview(Review review);
	public List<Review> getReviews(int movieID);
	public void updateReview(Review review);
	public void deleteReview(Review review);
	public List<Review> getMyReviews(User user);
}
