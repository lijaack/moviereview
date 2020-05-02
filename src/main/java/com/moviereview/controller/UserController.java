package com.moviereview.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.Model.User;
import com.moviereview.Service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/newUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void newUser(@RequestBody User user) {
				this.userService.newUser(user);
	}
	@RequestMapping(path="/updateUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void updateUser(@RequestBody User user) {
		this.userService.updateUser(user);
	}
	@RequestMapping(path="/login")
	@ResponseBody
	public void userLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
		this.userService.userLogin(username, password);
		session.setAttribute("username", username);
	}
	@RequestMapping(path="/getUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void getUser(@RequestParam String username) {
				this.userService.getUser(username);
	}
	@RequestMapping(path="/getAllUsers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void getAllUsers() {
				this.userService.getAllUsers();
	}
}
