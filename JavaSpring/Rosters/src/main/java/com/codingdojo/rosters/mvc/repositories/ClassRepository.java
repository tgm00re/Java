package com.codingdojo.rosters.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.rosters.mvc.models.Class;
import com.codingdojo.rosters.mvc.models.Student;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long>{

	List<Class> findAll();

	List<Class> findAllByStudents(Student student);
	
	List<Class> findByStudentsNotContains(Student student);
}
