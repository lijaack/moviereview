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

import com.moviereview.Model.Admin;
import com.moviereview.Model.User;
import com.moviereview.Service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(path="/newAdmin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public  ResponseEntity<Object> newAdmin(@RequestBody Admin admin, HttpSession session) {
		try {
			this.adminService.newAdmin(admin);
			return adminLogin(admin.getUsername(), admin.getPassword(), session);
		}catch(PersistenceException e){
			return ResponseEntity.badRequest().body("username already takened");
		}	
	}
	
	@RequestMapping(path="/updateAdmin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void updateAdmin(@RequestBody Admin admin, HttpSession session) {
		admin.setId((int) session.getAttribute("userID"));
		this.adminService.updateAdmin(admin);
	}
	
	@RequestMapping(path="/getAllAdmins", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Admin> getAllAdmins() {
		List<Admin> admins = this.adminService.getAllAdmins();
		return admins;
	}
	
	@RequestMapping(path="/getAdmin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getAdmin(@RequestParam String username) {
		try {
			Admin admin = this.adminService.getAdmin(username);
			return ResponseEntity.status(HttpStatus.OK).body(admin); 
		}catch(NoResultException e) {
			return ResponseEntity.badRequest().body("user not found");
		}

	}
	
	
	@RequestMapping(path="/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Object> adminLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
				try {
					Admin admin = this.adminService.getAdmin(username);
					if(admin.getPassword().equals(password)) {
						session.setAttribute("username", admin.getUsername());
						session.setAttribute("userID", admin.getId());
						return ResponseEntity.status(HttpStatus.OK).body(username);
					} else {
						return ResponseEntity.badRequest().body("invalid Password");
					}
				}catch(NoResultException e) {
					return ResponseEntity.badRequest().body("invalid login");
				}
				
	}
	
	
}
