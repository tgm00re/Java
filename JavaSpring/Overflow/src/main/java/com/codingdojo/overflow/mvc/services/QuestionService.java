package com.codingdojo.overflow.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.overflow.mvc.models.AddQuestion;
import com.codingdojo.overflow.mvc.models.Question;
import com.codingdojo.overflow.mvc.models.Tag;
import com.codingdojo.overflow.mvc.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	public Question createQuestion(Question question) {
		return questionRepo.save(question);
	}
	
	public List<Question> findAll(){
		return questionRepo.findAll();
	}
	
	public List<Question> findAllByTags(Tag tag){
		return questionRepo.findAllByTags(tag);
	}
	
	public List<Question> findByTagsNotContains(Tag tag){
		return questionRepo.findByTagsNotContains(tag);
	}
	
	public Question findOneById(Long id) {
		Optional<Question> optQ = questionRepo.findById(id);
		if(optQ.isPresent()) {
			return optQ.get();
		}
		return null;
	}
	
	
	//Checks to see if 3 or less tags are present. Returns an array of the tag subjects.
	public String[] validateQuestion(AddQuestion addQuestion, BindingResult result) {
		String tags = addQuestion.getTags().toLowerCase().replaceAll(" ","");
		String[] tagArr = tags.split(",");
		if(tagArr.length > 3) {
			result.rejectValue("tags", "MORETHAN3", "No more than 3 tags!");
		}
		return tagArr;
	}
}
