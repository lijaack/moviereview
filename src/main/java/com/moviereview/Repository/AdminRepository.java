package com.moviereview.Repository;

import java.util.List;

import com.moviereview.Model.Admin;

public interface AdminRepository {
	public void newAdmin(Admin admin);
	public Admin getAdmin(String username);
	public Admin adminLogin(String username, String password);
	public void updateAdmin(Admin admin);
	public List<Admin> getAllAdmins();
}
