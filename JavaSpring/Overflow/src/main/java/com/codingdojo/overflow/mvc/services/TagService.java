package com.codingdojo.overflow.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.overflow.mvc.models.Question;
import com.codingdojo.overflow.mvc.models.Tag;
import com.codingdojo.overflow.mvc.repositories.TagRepository;

@Service
public class TagService {

	
	@Autowired
	private TagRepository tagRepo;
	
	public Tag createTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public List<Tag> findAll(){
		return tagRepo.findAll();
	}
	
	public Tag findOneBySubject(String subject) {
		return tagRepo.findOneBySubject(subject);
	}
	
	public List<Tag> findAllByTags(Question question){
		return tagRepo.findAllByQuestions(question);
	}
	
	public List<Tag> findByTagsNotContains(Question question){
		return tagRepo.findByQuestionsNotContains(question);
	}
	
	public Tag findOneById(Long id) {
		Optional<Tag> optTag = tagRepo.findById(id);
		if(optTag.isPresent()) {
			return optTag.get();
		}
		return null;
	}
}
