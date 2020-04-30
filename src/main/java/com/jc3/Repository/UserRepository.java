package com.jc3.Repository;

import java.util.List;

import com.jc3.Model.User;

public interface UserRepository {
	public User getUser(String username);
	public List<User> getAllUsers();
	public void updateUser(User user);
	public void newUser(User user);
}
