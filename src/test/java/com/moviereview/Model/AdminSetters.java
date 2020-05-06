package com.moviereview.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import com.moviereview.Model.Admin;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
class AdminSetters {

		Admin admin;
		
		@BeforeAll
		public void setup() {
			 admin = new Admin(0, "admin", "password");
		}

		@Test
		public void testSetUsername(){
			admin.setUsername("Jeff");
			Assertions.assertEquals("Jeff", admin.getUsername());
		}
		
		@Test
		public void testSetPassword(){
			admin.setPassword("p1");
			Assertions.assertEquals("p1", admin.getPassword());
		}
		
		@Test
		public void testSetID(){
			admin.setId(1);
			Assertions.assertEquals(1, admin.getId());
		}

	}

