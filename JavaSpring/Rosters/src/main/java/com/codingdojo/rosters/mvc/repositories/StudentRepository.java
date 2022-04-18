package com.codingdojo.rosters.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.rosters.mvc.models.Student;
import com.codingdojo.rosters.mvc.models.Class;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	List<Student> findAll();
	
	List<Student> findAllByClasses(Class c);
	
	List<Student> findByClassesNotContains(Class c);
	
}
