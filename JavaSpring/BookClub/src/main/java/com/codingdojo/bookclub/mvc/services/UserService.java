package com.codingdojo.bookclub.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
