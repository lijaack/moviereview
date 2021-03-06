package com.moviereview.Repository;

import java.util.List;

import com.moviereview.Model.User;

public interface UserRepository {
	public User getUser(String username);
	public List<User> getAllUsers();
	public void updateUser(User user);
	public void newUser(User user);
	public User userLogin(String username, String password);
}
