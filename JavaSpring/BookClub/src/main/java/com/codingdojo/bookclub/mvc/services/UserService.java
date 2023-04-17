package com.codingdojo.bookclub.mvc.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.mvc.models.LoginUser;
import com.codingdojo.bookclub.mvc.models.User;
import com.codingdojo.bookclub.mvc.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	
	//WE WILL NEED TO VALIDATE BOTH OF THESE =======
	public User create(User user) {
		return userRepo.save(user);
	}
	
	public void register(User user, BindingResult result) {
		boolean isValid = true;
		User potentialUser = userRepo.findByName(user.getName());
		if(potentialUser != null) {
			//User exists already!
			result.rejectValue("email", "EXISTS", "Email already exists!");
			isValid = false;
		}
		
		if(isValid) {
			user.setName(BCrypt.hashpw(user.getName(), BCrypt.gensalt()));
		}
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
		User potentialUser = userRepo.findByName(loginUser.getName());
		if(potentialUser == null) {
			//User is not in DB
			result.rejectValue("email", "DNE", "Email does not exist.");
		} else {
			if(!BCrypt.checkpw(loginUser.getName(), potentialUser.getName())) {
				//Password isn't correct.
				result.rejectValue("password", "NOMATCH", "Incorrect password");
			}
		}
		return potentialUser;
	}
	
	
	
	public User update(User user) {
		return userRepo.save(user);
	}
	
	//==============================================
	
	public User findOneById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	
	public void delete(Long id) {
		userRepo.deleteById(id);
	}
	
	
	
	
	
	
}
