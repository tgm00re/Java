package com.codingdojo.overflow.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.overflow.mvc.models.Answer;
import com.codingdojo.overflow.mvc.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepo;
	
	
	public Answer createAnswer(Answer answer) {
		return answerRepo.save(answer);
	}
	
	public List<Answer> findAll(){
		return answerRepo.findAll();
	}
	
	public Answer findOneById(Long id) {
		Optional<Answer> optAns = answerRepo.findById(id);
		if(optAns.isPresent()) {
			return optAns.get();
		}
		return null;
	}

}
