package com.jc3.Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	@Id
	@Column
    private String username;
	@Column
    private String password;
	@Column
	private boolean isCritic;
	@Column
	private Date birthday;
	@Column
    private String country;
	@Column
    private String gender;
	
    public User() {
    	
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
    
    
}
