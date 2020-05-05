package com.moviereview.RepoTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.moviereview.Model.Admin;
import com.moviereview.Repository.AdminRepositoryImpl;


@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
class AdminRepoTest {

	@Mock
	AdminRepositoryImpl dao;

	@Mock
	List<Admin> requests = Arrays.asList(
			new Admin(0, "admin1", "password"),
			new Admin(1, "admin2", "password"));

	@BeforeAll
	public void setup() {

		dao = new AdminRepositoryImpl();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLogin() {
		Mockito.when(dao.adminLogin("admin2", "password2")).thenReturn(
				new Admin(2, "admin2", "password2"));

		Assertions.assertEquals(2, dao.adminLogin("admin2", "password2").getId());
	}
	
	@Test
	public void testGetAllAdmins() {
		List<Admin> requests = Arrays.asList(
				new Admin(0, "admin1", "password"),
				new Admin(1, "admin2", "password"));
		Mockito.when(dao.getAllAdmins()).thenReturn(
				requests);
		System.out.println(requests);
		Assertions.assertEquals(2,dao.getAllAdmins().size());
		Assertions.assertEquals("admin1",dao.getAllAdmins().get(0).getUsername());
		Assertions.assertEquals("admin2",dao.getAllAdmins().get(1).getUsername());
	}

}
