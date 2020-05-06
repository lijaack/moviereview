package com.moviereview.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviereview.Model.User;
import com.moviereview.Repository.UserRepository;


@Service
public class UserService {
	//configured autowired beans in applicaiton context
	@Autowired
	UserRepository userRepository;
	
	public UserService() {
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
	public void userLogin(String username, String password) {
		this.userRepository.userLogin(username, password);
	};

}
