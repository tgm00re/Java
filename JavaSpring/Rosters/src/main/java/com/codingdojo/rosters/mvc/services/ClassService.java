package com.codingdojo.rosters.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.rosters.mvc.models.Class;
import com.codingdojo.rosters.mvc.models.Student;
import com.codingdojo.rosters.mvc.repositories.ClassRepository;

@Service
public class ClassService {

	@Autowired
	private ClassRepository classRepo;
	
	public Class create(Class newClass) {
		return classRepo.save(newClass);
	}
	
	public List<Class> findAll(){
		return classRepo.findAll();
	}
	
	public Class findOneById(Long id) {
		Optional<Class> optC = classRepo.findById(id);
		if(optC.isPresent()) {
			return optC.get();
		}
		return null;
	}
	
	public List<Class> findByStudentsNotContains(Student student){
		return classRepo.findByStudentsNotContains(student);
	}
	
	public List<Class> findAllByStudents(Student student){
		return classRepo.findAllByStudents(student);
	}
}
