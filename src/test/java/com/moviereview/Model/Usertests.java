package com.moviereview.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;


@TestInstance(Lifecycle.PER_CLASS)
	class UserTests {
		
		User user;
		
		@SuppressWarnings("deprecation")
		@BeforeAll
		public void setup() {
			Date date = new Date(2014, 1, 1);
			 user = new User(0, "theguy", "password1", false, date, "USA", "male");
		}
		
		@Test
		public void testUserID(){
			Assertions.assertEquals(0, user.getId());
		}
		
		@Test
		public void testUserPassword(){
			Assertions.assertEquals("password1", user.getPassword());
		}
		
		@Test
		public void testIsUserCritic(){
			Assertions.assertEquals(false, user.isCritic());
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testUserBirthday(){
			Date date = new Date(2014, 1, 1);
			Assertions.assertEquals(date, user.getBirthday());
		}
		
		@Test
		public void testGetCountry(){
			Assertions.assertEquals("USA", user.getCountry());
		}
		
		@Test
		public void testGetGender(){
			Assertions.assertEquals("male", user.getGender());
		}
		
	

	}

