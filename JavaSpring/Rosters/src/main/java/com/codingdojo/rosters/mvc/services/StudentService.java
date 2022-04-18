package com.codingdojo.rosters.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.rosters.mvc.models.Class;
import com.codingdojo.rosters.mvc.models.Student;
import com.codingdojo.rosters.mvc.repositories.ClassRepository;
import com.codingdojo.rosters.mvc.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ClassService classServ;
	
	public Student create(Student student) {
		return studentRepo.save(student);
	}
	
	public List<Student> findAll(){
		return studentRepo.findAll();
	}
	
	public Student findOneById(Long id) {
		Optional<Student> optC = studentRepo.findById(id);
		if(optC.isPresent()) {
			return optC.get();
		}
		return null;
	}
	
	public List<Student> findByClassesNotContains(Class c){
		return studentRepo.findByClassesNotContains(c);
	}
	
	public List<Student> findAllByStudents(Class c){
		return studentRepo.findAllByClasses(c);
	}
	
	public Student addClass(Long studentId, Long classId) {
		Student s = this.findOneById(studentId);
		Class c = classServ.findOneById(classId);
		if(s == null || c == null) {
			return null;
		}
		s.getClasses().add(c);
		return studentRepo.save(s);
	}
}
