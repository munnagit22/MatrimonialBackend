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

import com.MatrimonyApp.Model.Mediator;
import com.MatrimonyApp.repo.MediatorRepo;
import com.MatrimonyApp.service.MediatorService;
import com.MatrimonyApp.utility.LoggingAspect;



@RestController
public class MediatorController {
	

	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Autowired
	MediatorService service;
	
	@Autowired
	MediatorRepo repo;
	
	@GetMapping("/interactlist")
	@CrossOrigin(origins = "http://localhost:4200")
	private ResponseEntity<List<Mediator>> getAllUser() throws Exception {
		logger.info("Customer list method started!");

		List<Mediator> response=  service.getAllInteract();
		  return new ResponseEntity<List<Mediator>>(response, HttpStatus.OK);

		
	}
	
	@GetMapping("/interactlist/{user}")
	@CrossOrigin(origins = "http://localhost:4200")
	private ResponseEntity<List<Mediator>> getAllUserbyRecever(@PathVariable("user") String user) throws Exception {
		logger.info("Customer list method started!");

		List<Mediator> response=  service.getAllInteractbyRecever(user);
		  return new ResponseEntity<List<Mediator>>(response, HttpStatus.OK);

		
	}
	
	@PutMapping("shedulemeeting")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Mediator> subcribeUser(@RequestBody Mediator interact) throws Exception {
	
		logger.info("shedule meeting ");

			
		
		Mediator mediator = service.shedulemeeting(interact);
			
			 return new   ResponseEntity<Mediator>(mediator, HttpStatus.OK);
			
		}
	
	@PutMapping("responce")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Mediator> setResponce(@RequestBody Mediator interact) throws Exception {
	
		logger.info("shedule meeting ");

			
		
		Mediator mediator = service.Responce(interact);
			
			 return new   ResponseEntity<Mediator>(mediator, HttpStatus.OK);
			
		}
	
	
	@PostMapping("sendrequest")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Mediator> registerUser(@RequestBody Mediator interact) throws Exception {
	
		logger.info("send request method started!");
		String send = interact.getSender();
		String rec = interact.getReceiver();
		
		
         
         
         Optional<Mediator> user = Optional.ofNullable(repo.findBySenderAndReceiver(send , rec));
			if (user.isPresent()) {
				throw new Exception("user with " + user + " already requested");
			}
		
		
			Mediator mediator = null;
			mediator = service.saveInteract(interact);
			
			 return new   ResponseEntity<Mediator>(mediator, HttpStatus.OK);
		
}

}
