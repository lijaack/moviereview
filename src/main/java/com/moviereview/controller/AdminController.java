package com.moviereview.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.Model.Admin;
import com.moviereview.Service.AdminService;

@RestController
@RequestMapping(path="/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(path="/newAdmin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void newAdmin(@RequestBody Admin admin) {
				this.adminService.newAdmin(admin);
	}
	@RequestMapping(path="/updateAdmin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void updateAdmin(@RequestBody Admin admin) {
		this.adminService.updateAdmin(admin);
	}
	@RequestMapping(path="/getAllAdmins", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void getAllAdmins() {
		this.adminService.getAllAdmins();
	}
	@RequestMapping(path="/getAdmin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void getAdmin(@RequestParam String username) {
				this.adminService.getAdmin(username);
	}
	@RequestMapping(path="/adminLogin")
	@ResponseBody
	public void adminLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
				this.adminService.adminLogin(username, password);
				session.setAttribute("username", username);
	}
	
	
}
