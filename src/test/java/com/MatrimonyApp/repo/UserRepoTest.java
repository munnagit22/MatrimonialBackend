package com.MatrimonyApp.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MatrimonyApp.Model.UserRegistration;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserRepoTest {
	
	@Autowired
	private UserRepo userRepo1;
	
	@Mock
	private UserRepo userRepo2;

	@Test
	void findByEmailTest() {

		String expected = "komal@gmail.com";
		
		UserRegistration newUser = userRepo1.findByEmail("komal@gmail.com");

		assertEquals(expected, newUser.getEmail());
//		verify(userRepo).findByEmail(expected);

	}
	
//	@Test
//	void testFindByBtype() {
//		
//		String type="Groom";
//	    
//	      List<UserRegistration> users = userRepo.findByBtype(type);
//      assertEquals(users.size(), users.size()>0);
//	      
//		verify(userRepo2).findByBtype(type);
//	
//	}
	
//
//	@Test
//	void testFindByEmailAndPassword() {
//		

//	}
//
//	@Test
//	void testFindByBtype() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetByEmail() {
//		fail("Not yet implemented");
//	}

}
