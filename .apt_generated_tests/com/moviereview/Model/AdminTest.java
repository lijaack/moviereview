package com.moviereview.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;

class AdminTest {

	@RunWith(JUnitPlatform.class)
	@TestInstance(Lifecycle.PER_CLASS)
	class AdminTestGet {
		
		Admin admin;
		
		@BeforeAll
		public void setup() {
			 admin = new Admin(0, "admin", "password");
		}
		
		@Test
		public void testGetUsername(){
			Assertions.assertEquals("admin", admin.getUsername());
		}
		
		@Test
		public void testGetPassword(){
			Assertions.assertEquals("password", admin.getPassword());
		}
		
		@Test
		public void testGetID(){
			Assertions.assertEquals(0, admin.getId());
		}
		
	

	}
}
