package com.moviereview.controller;

import java.util.List;

import javax.persistence.NoResultException;
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

import com.moviereview.Model.User;
import com.moviereview.Service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/newUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Object> newUser(@RequestBody User user, HttpSession session) {
		try {
			System.out.println(user);
			this.userService.newUser(user);
			return userLogin(user.getUsername(), user.getPassword(), session);
		}catch(PersistenceException e){
			return ResponseEntity.badRequest().body("username already takened");
		}
		
	}
	
	@RequestMapping(path="/updateUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void updateUser(@RequestBody User user, HttpSession session) {
			user.setId((int) session.getAttribute("userID"));
			this.userService.updateUser(user);
	}
	
	@RequestMapping(path="/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Object> userLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
		
		try {
			
			User user = this.userService.getUser(username);
			if(user.getPassword().equals(password)) {
				session.setAttribute("username", user.getUsername());
				session.setAttribute("userID", user.getId());
				return ResponseEntity.status(HttpStatus.OK).body(username);
			} else {
				return ResponseEntity.badRequest().body("invalid Password");
			}

		}catch(NoResultException e) {
			return ResponseEntity.badRequest().body("invalid Username");

		}
		
	}
	@RequestMapping(path="/getUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getUser(@RequestParam String username) {
		try {
			User user = this.userService.getUser(username);
			return ResponseEntity.status(HttpStatus.OK).body(user); 
		}catch(NoResultException e) {
			return ResponseEntity.badRequest().body("user not found");
		}
	}
	
	
	@RequestMapping(path="/getAllUsers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<User> getAllUsers() {
			List<User> users =this.userService.getAllUsers();
			return users;
	}
}
