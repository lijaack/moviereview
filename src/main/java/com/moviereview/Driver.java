package com.moviereview;


import java.sql.Date;

import com.moviereview.Model.Review;
import com.moviereview.controller.ReviewController;

public class Driver {
	public static void main(String[] args) {
//		UserService userService = new UserService();
//		
//		Date date = new Date(2000, 13, 22);
//		User user = new User("mrmovie", "ilovemovies", true, date, "United States", "Male");
//		
//		//userService.newUser(user);
//		
//		userService.updateUser(user);
		
		Date date = new Date(2000, 13, 22);
		
		ReviewController reviewController = new ReviewController();
		
		Review review = new Review("This movie sucked", 0, date, "imdbid", 6);
		review.getMovieScore();
		reviewController.newUReview(review, null);
	}
}
