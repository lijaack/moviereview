package com.moviereview;


import java.sql.Date;

import com.moviereview.Model.User;
import com.moviereview.Service.UserService;

public class Driver {
	public static void main(String[] args) {
		UserService userService = new UserService();
		
		Date date = new Date(3900, 1, 15);
		User user = new User("mrmovie", "ilovemovies", true, date, "United States", "Male");
		
		userService.newUser(user);
		System.out.println(System.getenv("url"));
		System.out.println(System.getenv("username"));
	}
}
