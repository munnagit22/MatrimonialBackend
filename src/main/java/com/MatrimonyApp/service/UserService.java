package com.MatrimonyApp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MatrimonyApp.CustomException.UserAlreadyExistException;
import com.MatrimonyApp.Model.UserRegistration;
import com.MatrimonyApp.repo.UserRepo;
import com.MatrimonyApp.utility.AESEncryption;
import com.MatrimonyApp.utility.AgeCount;

@Service
public class UserService {

	public UserService(UserRepo repo) {
		super();
		this.repo = repo;
	}

	@Autowired
	private UserRepo repo;

	public static String getDateEnd(int months) {
		LocalDate date = LocalDate.now();

		return date.plusMonths(months).toString();
	}

	public static String getCurrentDate() {

		return LocalDate.now().toString();
	}

	public UserRegistration saveUser(UserRegistration userRegistration) {
		// TODO Auto-generated method stub

		String tempEmailId = userRegistration.getEmail();

		Optional<UserRegistration> user = Optional.ofNullable(repo.findByEmail(tempEmailId));
		if (user.isPresent()) {
			throw new UserAlreadyExistException("user with " + user + " already exist");
		}

		String pass = AESEncryption.encrypt(userRegistration.getPassword());
		userRegistration.setPassword(pass);
		int age = AgeCount.count(userRegistration.getDateOfBirth());
		userRegistration.setAge(age);
		userRegistration.setStatus("Active");
		userRegistration.setSubcription("NA");

		return repo.save(userRegistration);
	}

	public UserRegistration subUser(UserRegistration userRegistration) throws Exception {

		Optional<UserRegistration> user = Optional.ofNullable(repo.findByEmail(userRegistration.getEmail()));
		user.get().setSubcription("subscribe");

		if (!user.isPresent()) {
			String str = userRegistration.getSubcription();
			user.get().setSubstard(getCurrentDate());
			if (str == "3 Months") {
				user.get().setSubend(getDateEnd(3));
			} else if (str == "6 Months") {
				user.get().setSubend(getDateEnd(6));
			} else {
				user.get().setSubend(getDateEnd(12));
			}

		}
		return repo.save(user.get());
	}

	public List<UserRegistration> getAllUsers() throws Exception {

		return repo.findAll();
	}

	public List<UserRegistration> getAllbytype(String type) throws Exception {
		String str = "";
		if (type.equals("Groom")) {
			str = "Bride";
		} else {
			str = "Groom";
		}

		

		return repo.findByBtype(str);
	}

	public UserRegistration changebystatus(UserRegistration userRegistration) {
		UserRegistration user = new UserRegistration();
		user = repo.findByEmail(userRegistration.getEmail());
		if (user.getStatus().equals("Active")) {

			user.setStatus("Deactive");
		} else {

			user.setStatus("Active");
		}
		return repo.save(user);
	}

}
