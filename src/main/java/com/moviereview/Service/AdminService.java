package com.moviereview.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.moviereview.Model.Admin;
import com.moviereview.Model.User;
import com.moviereview.Repository.AdminRepository;
import com.moviereview.Repository.UserRepository;

public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	public AdminService() {
	}
	
	public Admin getAdmin(String username) {
		return this.adminRepository.getAdmin(username);
	}
	public List<Admin> getAllUsers(){
		return this.adminRepository.getAllAdmins();
	}
	public void updateUser(Admin admin) {
		this.adminRepository.updateAdmin(admin);
	}
	public void newAdmin(Admin admin) {
		this.adminRepository.newAdmin(admin);
	}

	public void adminLogin(String username, String password) {
		this.adminRepository.adminLogin(username, password);
	};

}
