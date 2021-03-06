package com.moviereview.controller;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.Model.Review;
import com.moviereview.Service.ReviewService;

@CrossOrigin(origins = {"http://localhost:4200", "http://moviereviewapp1.s3-website-us-west-1.amazonaws.com"})
@RestController
@RequestMapping(path="/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	@RequestMapping(path="/newReview", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Object> newUReview(@RequestBody Review review,HttpSession session) {
		try {
			this.reviewService.newReview(review);
			return ResponseEntity.status(HttpStatus.OK).body(review);
		}catch(PersistenceException e){
			return ResponseEntity.badRequest().body("You have already reviewed this movie");
		}
	}
	
	@RequestMapping(path="/updateReview", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Object> updateReview(@RequestBody Review review) {
		try {
			this.reviewService.updateReview(review);
			return ResponseEntity.status(HttpStatus.OK).body(review);
		}catch(PersistenceException e){
			return ResponseEntity.badRequest().body("You have already reviewed this movie");
		}

	}
	
	@RequestMapping(path="/getByMovieID", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Review> getByMovieID(@RequestParam("movieID") String movieID) {
		 List<Review> reviews = this.reviewService.getReviewsByMovieId(movieID);

		 return reviews;
	}
	
	@RequestMapping(path="/getByUserID", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Review> getByUserID(@RequestParam("movieID") int userID) {
		List<Review> reviews = this.reviewService.getReviewsByUserId(userID);
		return reviews;
	}
	
	
}
