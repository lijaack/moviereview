package com.moviereview.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;

class ReviewTest {


	@TestInstance(Lifecycle.PER_CLASS)
	class ReviewTestGet {
		
		Review review;
		
		@SuppressWarnings("deprecation")
		@BeforeAll
		public void setup() {
			Date date = new Date(2014, 1, 1);
			review = new Review(0, "this is a review", 5, date, "imdbID", 7);
		}
		
		@Test
		public void testReviewGetID(){
			Assertions.assertEquals(0, review.getId());
		}
		
		@Test
		public void testReviewGetReview(){
			Assertions.assertEquals("this is a review", review.getReview());
		}
		
		@Test
		public void testReviewGetScore(){
			Assertions.assertEquals(5, review.getMovieScore());
		}
		///
		@Test
		public void testReviewGetDate(){
			Date date = new Date(2014, 1, 1);
			Assertions.assertEquals(date, review.getDateCreated());
		}
		
		@Test
		public void testReviewGetMovieID(){
			Assertions.assertEquals("imdbID", review.getMovieID());
		}
		
		@Test
		public void testReviewGetUserID(){
			Assertions.assertEquals(7, review.getUserID());
		}
		
	

	}
}
