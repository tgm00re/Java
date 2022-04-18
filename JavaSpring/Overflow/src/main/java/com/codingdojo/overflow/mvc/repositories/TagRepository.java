package com.codingdojo.overflow.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.mvc.models.Question;
import com.codingdojo.overflow.mvc.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long>{
	List<Tag> findAll();
	
	List<Tag> findAllByQuestions(Question question);
	
	List<Tag> findByQuestionsNotContains(Question question);
	
	Tag findOneBySubject(String subject);
}
