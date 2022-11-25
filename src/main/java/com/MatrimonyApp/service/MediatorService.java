package com.MatrimonyApp.service;

import java.util.List;
import java.util.Observable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MatrimonyApp.Model.Mediator;
import com.MatrimonyApp.Model.UserRegistration;
import com.MatrimonyApp.repo.MediatorRepo;

@Service
public class MediatorService {
	
	
	public MediatorService(MediatorRepo repo) {
		super();
		this.repo = repo;
	}

	@Autowired
	MediatorRepo repo;

	public Mediator saveInteract(Mediator interact) throws Exception{
		// TODO Auto-generated method stub
		return repo.save(interact);
	}

	public List<Mediator> getAllInteract() throws Exception{
		
		return repo.findAll();
	}
	
	public List<Mediator> getAllInteractbyRecever(String receiver ) {
		// TODO Auto-generated method stub
		List<Mediator> rec=repo.findByReceiver(receiver);
		return rec;
	}

	@SuppressWarnings("deprecation")
	public Mediator shedulemeeting(Mediator mediator) throws Exception{
		
		Optional<Mediator> sender = Optional.ofNullable(repo.getById(mediator.getId()));
		
		
		sender.get().setMediatoraction(mediator.getMediatoraction());
		return repo.save(sender.get());
	}

	@SuppressWarnings("deprecation")
	public Mediator Responce(Mediator mediator) throws Exception{
		
		Optional<Mediator> sender = Optional.ofNullable(repo.getById(mediator.getId()));
		
		
		sender.get().setResponce(mediator.getResponce());
		return repo.save(sender.get());
	}



}
