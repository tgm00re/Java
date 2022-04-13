package com.codingdojo.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.studentroster.mvc.models.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();
	
	List<Student> findByDormitory_idIsNull();
}
