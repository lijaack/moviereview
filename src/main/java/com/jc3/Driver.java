package com.jc3;

import java.sql.Date;

import com.jc3.Model.User;
import com.jc3.Service.UserService;

public class Driver {
	public static void main(String[] args) {
		UserService userService = new UserService();
		
		Date date = new Date(3900, 1, 15);
		User user = new User("mrmovie", "ilovemovies", true, date, "United States", "Male");
		
		userService.newUser(user);
	}
}
