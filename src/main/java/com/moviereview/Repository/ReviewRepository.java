package com.moviereview.Repository;
import java.util.List;

import com.moviereview.Model.Review;

public interface ReviewRepository {
	public List<Review> getReviewsByMovieId(int id);
	public List<Review> getReviewsByUserId(int id);
	public void insertReview(Review review);
	public void updateReview(Review review);
}
