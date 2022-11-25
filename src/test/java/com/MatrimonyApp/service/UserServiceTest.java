package com.MatrimonyApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.MatrimonyApp.Model.UserRegistration;
import com.MatrimonyApp.repo.UserRepo;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	private UserService userService;

	@Mock
	private UserRepo userRepo;

	@BeforeEach
	void setUp() throws Exception {
		this.userService = new UserService(userRepo);
	}

	@Test
	void testGetAllUsers() throws Exception {
		userService.getAllUsers();
		verify(userRepo).findAll();

	}

	@Test
	void testGetAllbytype() throws Exception {
		userService.getAllbytype("Groom");
		verify(userRepo).findByBtype("Bride");
	}

	@Test
	void testSaveUser() {
		UserRegistration user = new UserRegistration(0, "Groom", "amayra", 0, "a@gmail.com", "amayra", "2022-11-02", "3", null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		userService.saveUser(user);
		verify(userRepo).findByEmail("a@gmail.com");

	}
	
//	 @Test
//	 void testSubUser() throws Exception {
//
//		 //Save User
//		 	UserRegistration user = new UserRegistration(1, "Groom", "amayra", 0, "a@gmail.com", "amayra", "2022-11-02", "3", null, null, null, null, null, null, null, null, null, null, null, null, null);
//		 	userRepo.save(user);
//		 	
//		 	//Update Subscription by subUser function
//		 	UserRegistration user1 = new UserRegistration(1, "Groom", "amayra", 0, "a@gmail.com", "amayra", "2022-11-02", "3", null, null, null, null, null, null, null, null, "6 Months", null, null, null, null);
//			userService.subUser(user1);
//			
//			verify(userRepo).findByEmail("a@gmail.com").getSubcription();
////			assertEquals( "subscribe", user2.getSubcription());
//			
//	 }
//	 
//	 @Test
//		 void testChangebystatus() {
//		 UserRegistration user = new UserRegistration(1, "Groom", "amayra", 0, "a@gmail.com", "amayra", "2022-11-02", "3", null, null, null, null, null, null, null, "Active", null, null, null, null, null);
//		 userRepo.save(user);
//		 
//		// UserRegistration user1 = new UserRegistration(1, "Groom", "amayra", 0, "a@gmail.com", "amayra", "2022-11-02", "3", null, null, null, null, null, null, null, "Active", "6 Months", null, null, null, null);
//			
//		 	
//		 	UserRegistration result = userService.changebystatus(user);
//		 	assertEquals( "Deactive", result.getStatus());
//		 }
	 

	//
	//

	//
	// @Test
	// void testSubUser() {
	// fail("Not yet implemented");
	// }
	//

	//
	// @Test
	// void testGetAllbytype() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testChangebystatus() {
	// fail("Not yet implemented");
	// }

}
