package com.MatrimonyApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MatrimonyApp.Model.UserRegistration;


public interface UserRepo extends JpaRepository<UserRegistration, Integer>{

	UserRegistration findByEmail(String tempEmailId);

	UserRegistration findByEmailAndPassword(String email, String password);

	List<UserRegistration> findByBtype(String type);

	UserRegistration getByEmail(String email);

}
