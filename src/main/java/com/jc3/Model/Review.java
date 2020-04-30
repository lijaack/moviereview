package com.jc3.Model;

import java.sql.Date;

public class Review {
	private int id;
    private String review;
    private int movieScore;
    private Date dateCreated;
    private String imdbID;
    private int userID;
	
    public Review(int id, String review, int movieScore, Date dateCreated, String imdbID, int userID) {
		super();
		this.id = id;
		this.review = review;
		this.movieScore = movieScore;
		this.dateCreated = dateCreated;
		this.imdbID = imdbID;
		this.userID = userID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getMovieScore() {
		return movieScore;
	}

	public void setMovieScore(int movieScore) {
		this.movieScore = movieScore;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
    
    
}
