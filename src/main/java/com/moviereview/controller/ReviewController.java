package com.moviereview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.Model.Review;
import com.moviereview.Service.ReviewService;

@RestController
@RequestMapping(path="/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	@RequestMapping(path="/newReview", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void newUser(@RequestBody Review review) {
				this.reviewService.newReview(review);
	}
	@RequestMapping(path="/updateReview", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void updateReview(@RequestBody Review review) {
				this.reviewService.updateReview(review);
	}
	@RequestMapping(path="/getByMovieID", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void getByMovieID(@RequestBody int id) {
				this.reviewService.getReviewsByMovieId(id);
	}
	@RequestMapping(path="/getByUserID", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void getByUserID(@RequestBody int id) {
				this.reviewService.getReviewsByUserId(id);
	}
	
	
}
