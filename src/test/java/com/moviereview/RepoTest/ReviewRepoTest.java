package com.moviereview.RepoTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.moviereview.Model.Review;
import com.moviereview.Repository.ReviewRepositoryImpl;


@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
class ReviewRepoTest {

	@Mock
	ReviewRepositoryImpl dao;

	@SuppressWarnings("deprecation")
	@Mock
	Date date = new Date(2014, 1, 1);
	@SuppressWarnings("deprecation")
	Date dateA = new Date(2015, 12, 11);
	List<Review> requests = Arrays.asList(
			new Review(0, "this is a review", 5, date, "imdbID", 7),
			new Review(1, "this is also a review", 6, dateA, "MYID", 8),
			new Review(2, "this is MY review", 7, date, "MYID", 9));

	@BeforeAll
	public void setup() {

		dao = new ReviewRepositoryImpl();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetReviewsByUserId() {
		List<Review> MYID = Arrays.asList(new Review(0, "this is a review", 5, date, "imdbID", 7));
		Mockito.when(dao.getReviewsByUserId(7)).thenReturn(
				MYID);

		Assertions.assertEquals(1, dao.getReviewsByUserId(7).size());
		Assertions.assertEquals(7, dao.getReviewsByUserId(7).get(0).getUserID());
	}
	@Test
	public void testGetReviewByMovieID() {
		List<Review> MYID = Arrays.asList(
				new Review(1, "this is also a review", 6, dateA, "MYID", 8),
				new Review(2, "this is MY review", 7, date, "MYID", 9));
		Mockito.when(dao.getReviewsByMovieId("MYID")).thenReturn(
				MYID);

		Assertions.assertEquals(2, dao.getReviewsByMovieId("MYID").size());
		Assertions.assertEquals(8, dao.getReviewsByMovieId("MYID").get(0).getUserID());
		Assertions.assertEquals("this is MY review", dao.getReviewsByMovieId("MYID").get(1).getReview());
	}
	
//	@Test
//	public void testUpdateReview() {
//		List<Review> MYID = Arrays.asList(
//				new Review(1, "this is also a review", 6, dateA, "MYID", 8),
//				new Review(2, "this is MY review", 7, date, "MYID", 9));
//		Review review;
//		Mockito.when(dao.updateReview(review).getReviewsByMovieId("MYID")).thenReturn(
//				MYID);
//
//		Assertions.assertEquals(2, dao.getReviewsByMovieId("MYID").size());
//		Assertions.assertEquals(8, dao.getReviewsByMovieId("MYID").get(0).getUserID());
//		Assertions.assertEquals("this is MY review", dao.getReviewsByMovieId("MYID").get(1).getReview());
//	}
//	@Test
//	public void testInsertReview() {
//		List<Review> MYID = Arrays.asList(new Review(0, "this is a review", 5, date, "imdbID", 7));
//		Review review = new Review(3, "this is the insert review", 7, date, "imdbID", 8);
//		MYID.add(review);
//		Mockito.when(dao.getReviewsByUserId(3)).thenReturn(
//				MYID);
//
//		Assertions.assertEquals(1, dao.getReviewsByUserId(3).size());
//		Assertions.assertEquals("this is the insert review", dao.getReviewsByUserId(3).get(0).getReview());
//	}
//	

}
