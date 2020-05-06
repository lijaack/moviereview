package com.moviereview.RepoTest;

import java.sql.Date;
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
import com.moviereview.Model.User;
import com.moviereview.Repository.AdminRepositoryImpl;
import com.moviereview.Repository.UserRepositoryImpl;


@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
class UserRepoTest {

	@Mock
	UserRepositoryImpl dao;

	@SuppressWarnings("deprecation")
	@Mock
	Date date = new Date(2014, 1, 1);
	List<User> requests = Arrays.asList(
			new User(0, "theguy", "password1", false, date, "USA", "male"),
			new User(1, "thegirl", "password2", true, date, "France", "female"),
			new User(2, "thething", "password3", true, date, "UK", "other"));

	@BeforeAll
	public void setup() {

		dao = new UserRepositoryImpl();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLogin() {
		Mockito.when(dao.userLogin("theguy", "password1")).thenReturn(
				requests.get(0));

		Assertions.assertEquals(0, dao.userLogin("theguy", "password1").getId());
	}
	
	@Test
	public void testGetAllUsers() {
		List<User> requests = Arrays.asList(
				new User(0, "theguy", "password1", false, date, "USA", "male"),
				new User(1, "thegirl", "password2", true, date, "France", "female"),
				new User(2, "thething", "password3", true, date, "UK", "other"));

		Mockito.when(dao.getAllUsers()).thenReturn(
				requests);
		Assertions.assertEquals(3,dao.getAllUsers().size());
		Assertions.assertEquals("theguy",dao.getAllUsers().get(0).getUsername());
		Assertions.assertEquals("thegirl",dao.getAllUsers().get(1).getUsername());
	}

}
