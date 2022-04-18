package com.codingdojo.overflow.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.mvc.models.Question;
import com.codingdojo.overflow.mvc.models.Tag;


@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>{
	
	List<Question> findAll();
	
	List<Question> findAllByTags(Tag tag);
	
	List<Question> findByTagsNotContains(Tag tag);
}
