package com.MatrimonyApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MatrimonyApp.Model.Mediator;

@Repository
public interface MediatorRepo extends JpaRepository<Mediator, Integer>{

	Mediator findBySenderAndReceiver(String send, String rec);

	




	List<Mediator> findByReceiver(String receiver);



}
