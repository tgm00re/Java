package com.codingdojo.loginandregistration.mvc.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.loginandregistration.mvc.models.LoginUser;
import com.codingdojo.loginandregistration.mvc.models.User;
import com.codingdojo.loginandregistration.mvc.repositories.UserRepo;

@Service
public class UserServ {
	@Autowired
	private UserRepo userRepo;
	
	
	public void register(User newUser, BindingResult result) {
		if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Exists", "Email already exists!");
		}
		if(!newUser.getConfirmPassword().equals(newUser.getPassword())) {
			System.out.println("Password didn't match!");
			result.rejectValue("confirmPassword", "Match", "Confirm password must match password.");
		}
		if(!newUser.getPassword().matches("^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")) {
			result.rejectValue("password", "Match", "Password must have at least 1 uppercase letter, 1 lowercase letter, and a symbol.");
		}
	}
	
	public User createUser(User newUser) {
		return userRepo.save(newUser);
	}
	
	
	public User login(LoginUser user, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(user.getEmail());
		if(!optionalUser.isPresent()) {
			result.rejectValue("email", "EMAILDNE", "Email does not exist.");
			return null;
		}
		User foundUser = optionalUser.get();
		if(!BCrypt.checkpw(user.getPassword(), foundUser.getPassword())) {
			System.out.println("Passwords dont match silly goose!");
			result.rejectValue("password", "NOMATCH", "Incorrect Password.");
			return null;
		}
		
		return foundUser;
	}
	
}
