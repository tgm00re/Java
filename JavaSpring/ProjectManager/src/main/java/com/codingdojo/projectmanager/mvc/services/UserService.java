package com.codingdojo.projectmanager.mvc.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.projectmanager.mvc.models.LoginUser;
import com.codingdojo.projectmanager.mvc.models.User;
import com.codingdojo.projectmanager.mvc.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	//CREATE
	public User create(User user) {
		return userRepo.save(user);
	}
		//Validation
	public User validateUserLogin(LoginUser loginUser, BindingResult result) {
		User user = this.findOneByEmail(loginUser.getEmail());
		if(user == null) {
			result.rejectValue("email", "EMAILDNE", "Email does not exist 8(");
			return null;
		}
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "INCORRECTPASS", "Incorrect password");
			return null;
		}
		return user;
	}
	
	public void registerUser(User user, BindingResult result) {
		User potentialUser = this.findOneByEmail(user.getEmail());
		if(potentialUser != null) {
			result.rejectValue("email", "EMAILEXISTS", "email already exists.");
		}
		if(!user.getConfirmPassword().equals(user.getPassword())) {
			result.rejectValue("confirmPassword", "CONFIRMPASS", "confirm password must match password");
		}
	}
	
	//READ
	public User findOneById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findOneByEmail(String email) {
		User user = userRepo.findOneByEmail(email);
		return user;
	}
	
	
	//UPDATE
	public User update(User user) {
		return userRepo.save(user);
	}
	
	
	//DELETE
	//Not needed for this project
	
}
