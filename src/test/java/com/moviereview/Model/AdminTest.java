package com.moviereview.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;

@TestInstance(Lifecycle.PER_CLASS)
class AdminTest {

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

