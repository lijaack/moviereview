package com.jc3.Service;

import java.util.List;

import com.jc3.Model.User;
import com.jc3.Repository.UserRepository;
import com.jc3.Repository.UserRepositoryImpl;

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
