package com.MatrimonyApp.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MatrimonyApp.Model.UserRegistration;
import com.MatrimonyApp.repo.UserRepo;
import com.MatrimonyApp.service.UserService;
import com.MatrimonyApp.utility.AESEncryption;
import com.MatrimonyApp.utility.LoggingAspect;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Usercontroller {
	

	   

	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	

	@Autowired
	UserService service;
	
	@Autowired
	UserRepo repo;
	
	@GetMapping("/users")
	private ResponseEntity<List<UserRegistration>> getAllUser() throws Exception {
		logger.info("Customer list method started!");

		List<UserRegistration> response=  service.getAllUsers();
		  return new ResponseEntity<List<UserRegistration>>(response, HttpStatus.OK);

		
	}

		@PostMapping("adduser")
		public ResponseEntity<UserRegistration> registerUser(@RequestBody UserRegistration userRegistration) throws Exception {
		
			logger.info("Customer registration method started!");
			
			UserRegistration user= service.saveUser(userRegistration);
				
				 return new   ResponseEntity<UserRegistration>(user, HttpStatus.OK);
			
	}
		
		@PutMapping("subcrib")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<UserRegistration> subcribeUser(@RequestBody UserRegistration userRegistration) throws Exception {
		
			logger.info("Customer subcription method started!");
	
				
			
				UserRegistration obj = service.subUser(userRegistration);
				
				 return new   ResponseEntity<UserRegistration>(obj, HttpStatus.OK);
				
			}
			
			
		
		
		@PutMapping("changestatus")
		public ResponseEntity<UserRegistration> changestatus(@RequestBody UserRegistration userRegistration) throws Exception {
		
			logger.info("Customer changestatus method started!");
	
				
			
				UserRegistration user = service.changebystatus(userRegistration);
				
				 return new   ResponseEntity<UserRegistration>(user, HttpStatus.OK);
				
			}
	
		
		@PostMapping("loginuser")
		public ResponseEntity<UserRegistration> loginUser(@RequestBody UserRegistration userRegistration) throws Exception {
		
			logger.info("Customer login method started!");
	
			String email = userRegistration.getEmail();
			String password =AESEncryption.encrypt(userRegistration.getPassword()) ;

			Optional<UserRegistration> user = null;
			if (email != null && password != null) {

				user = Optional.ofNullable(repo.findByEmailAndPassword(email,password));

			
			}
			if (!user.isPresent()) {
				throw new Exception("Bad Credentials");
			}
			
			 return new ResponseEntity<UserRegistration>(user.get(), HttpStatus.OK);
			
	}
		
		@GetMapping("/users/{type}")
		public ResponseEntity<List<UserRegistration>> getfindByType(@PathVariable("type") String type) {
			
			logger.info("Customer list method started!");

			List<UserRegistration> response = null;
			try {
				response = service.getAllbytype(type);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return new ResponseEntity<List<UserRegistration>>(response, HttpStatus.OK);

		}
	
	
}
