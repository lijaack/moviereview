package com.moviereview.Service;

import java.util.List;

import com.moviereview.Model.User;
import com.moviereview.Repository.UserRepository;
import com.moviereview.Repository.UserRepositoryImpl;

public class UserService {
	
	UserRepository  userRepository;
	
	public UserService() {
		this.userRepository = new UserRepositoryImpl();
	}
	
	public User getUser(String username) {
		return this.userRepository.getUser(username);
	}
	public List<User> getAllUsers(){
		return this.userRepository.getAllUsers();
	}
	public void updateUser(User user) {
		this.userRepository.updateUser(user);
	}
	public void newUser(User user) {
		this.userRepository.newUser(user);
	}
}
