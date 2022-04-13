package com.codingdojo.studentroster.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.mvc.models.Dormitory;
import com.codingdojo.studentroster.mvc.models.Student;
import com.codingdojo.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	private final DormitoryService dormitoryService;
	
	public StudentService(StudentRepository studentRepository, DormitoryService dormitoryService) {
		this.studentRepository = studentRepository;
		this.dormitoryService = dormitoryService;
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student create(Student student) {
		return studentRepository.save(student);
	}
	
	public Student findOneById(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		}
		return null;
	}
	
	public Student addStudentToDormitory(Long id, Long dormitoryId) {
		Optional<Student> student = studentRepository.findById(id);
		Dormitory dormitory = dormitoryService.findOneById(dormitoryId);
		if(!student.isPresent() || dormitory == null) {
			return null;
		}
		student.get().setDormitory(dormitory);
		return studentRepository.save(student.get());
		
	}
	
	public List<Student> findStudentsWithoutDormitory() {
		return studentRepository.findByDormitory_idIsNull();
	}
	
}
