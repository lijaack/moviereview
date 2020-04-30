package com.moviereview.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin {
	
	@Id 
	@GeneratedValue(generator = "admin_id_seq", strategy = GenerationType.AUTO) 
	@SequenceGenerator(name="admin_id_seq", allocationSize = 1) 
	@Column(name="id")
	private int id;
	@Column(name="username")
    private String username;
	@Column(name="password")
    private String password;
	
    public Admin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
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
    
    
}
