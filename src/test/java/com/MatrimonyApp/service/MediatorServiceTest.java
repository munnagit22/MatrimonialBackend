package com.MatrimonyApp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.MatrimonyApp.repo.MediatorRepo; 


@ExtendWith(MockitoExtension.class)
class MediatorServiceTest {


	private MediatorService mediatorService;

	@Mock
	private MediatorRepo mediatorRepo;

	@BeforeEach
	void setUp() throws Exception {
		this.mediatorService = new MediatorService(mediatorRepo);
	}
	


	@Test
	void testGetAllInteract() throws Exception {
		mediatorService.getAllInteract();
	verify(mediatorRepo).findAll();

}





}
