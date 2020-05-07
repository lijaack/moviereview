package com.moviereview.Model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="reviews")
public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(generator = "review_id_seq", strategy = GenerationType.AUTO) 
	@SequenceGenerator(name="review_id_seq", allocationSize = 1) 
	@Column(name="id")
	private int id;
	@Column(name="review")
    private String review;
	@Column(name="movieScore")
    private int movieScore;
	@Column(name="dateCreated")
    private Date dateCreated;
	@Column(name="movieID")
    private String movieID;
	@Column(name="userID")
    private int userID;
//	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//			 CascadeType.DETACH, CascadeType.REFRESH})
//	@JoinColumn(name="users")
//	private User user;

	public Review() {
		
	}
	
    public Review(int id, String review, int movieScore, Date dateCreated, String imdbID, int userID) {
		super();
		this.id = id;
		this.review = review;
		this.movieScore = movieScore;
		this.dateCreated = dateCreated;
		this.movieID = imdbID;
		this.userID = userID;
	}
    
    public Review( String review, int movieScore, Date dateCreated, String imdbID, int userID) {
		super();
		this.review = review;
		this.movieScore = movieScore;
		this.dateCreated = dateCreated;
		this.movieID = imdbID;
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

	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String imdbID) {
		this.movieID = imdbID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", review=" + review + ", movieScore=" + movieScore + ", dateCreated=" + dateCreated
				+ ", movieID=" + movieID + ", userID=" + userID + "]";
	}
    
}
