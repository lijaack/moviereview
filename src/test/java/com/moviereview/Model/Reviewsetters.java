package com.moviereview.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;

@TestInstance(Lifecycle.PER_CLASS)
class ReviewSet {



		Review review;
		
		@SuppressWarnings("deprecation")
		@BeforeAll
		public void setup() {
			Date date = new Date(2014, 1, 1);
			review = new Review(0, "this is a review", 5, date, "imdbID", 7);
		}
		
	
		///Setters
		@Test
		public void testReviewSetID(){
			review.setId(1);
			Assertions.assertEquals(1, review.getId());
		}
		
		@Test
		public void testReviewSetReview(){
			review.setReview("this review");
			Assertions.assertEquals("this review", review.getReview());
		}
		
		@Test
		public void testReviewSetScore(){
			review.setMovieScore(8);
			Assertions.assertEquals(8, review.getMovieScore());
		}
		
		@Test
		public void testReviewSetDate(){
			Date date = new Date(2054, 2, 2);
			review.setDateCreated(date);
			Assertions.assertEquals(date, review.getDateCreated());
		}
		
		@Test
		public void testReviewSetMovieID(){
			review.setMovieID("ID");
			Assertions.assertEquals("ID", review.getMovieID());
		}
		
		@Test
		public void testReviewSetUserID(){
			review.setUserID(12);
			Assertions.assertEquals(12, review.getUserID());
		}
	

	}

