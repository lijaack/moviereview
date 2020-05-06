package com.moviereview.Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "users")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(generator = "user_id_seq", strategy = GenerationType.AUTO) 
	@SequenceGenerator(name="user_id_seq", allocationSize = 1) 
	@Column
	private int id;
	@Column(name="username", unique=true)
    private String username;
	@Column(name="password")
    private String password;
	@Column(name="isCritic")
	private boolean isCritic;
	@Column(name="birthday")
	private Date birthday;
	@Column(name="country")
    private String country;
	@Column(name="gender")
    private String gender;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user", cascade= {CascadeType.ALL})
	private List<Review> reviews;
	
    public User() {
    	
    }

    public User(int id, String username, String password, boolean isCritic, Date birthday, String country,
			String gender) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isCritic = isCritic;
		this.birthday = birthday;
		this.country = country;
		this.gender = gender;
	}
    
    public User( String username, String password, boolean isCritic, Date birthday, String country,
			String gender) {
		super();
		this.username = username;
		this.password = password;
		this.isCritic = isCritic;
		this.birthday = birthday;
		this.country = country;
		this.gender = gender;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isCritic() {
		return isCritic;
	}


	public void setCritic(boolean isCritic) {
		this.isCritic = isCritic;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
//	public List<Review> getReviews() {
//		return reviews;
//	}
//
//	public void setCourses(List<Review> courses) {
//		this.reviews = courses;
//	}
//	
//	// add convenience methods for bi-directional relationship
//	
//	public void add(Review tempReview) {
//		
//		if (reviews == null) {
//			reviews = new ArrayList<>();
//		}
//		reviews.add(tempReview);
//		tempReview.setUser(this);
//	}
//
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", isCritic=" + isCritic
				+ ", birthday=" + birthday + ", country=" + country + ", gender=" + gender + "]";
	}

    
    
}
