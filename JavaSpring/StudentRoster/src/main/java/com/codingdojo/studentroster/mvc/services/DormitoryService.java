package com.codingdojo.studentroster.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.mvc.models.Dormitory;
import com.codingdojo.studentroster.mvc.models.Student;
import com.codingdojo.studentroster.repositories.DormitoryRepository;

@Service
public class DormitoryService {
	private final DormitoryRepository dormitoryRepository;
	
	public DormitoryService(DormitoryRepository dormitoryRepository) {
		this.dormitoryRepository = dormitoryRepository;
	}
	
	public List<Dormitory> findAll(){
		return dormitoryRepository.findAll();
	}
	
	public Dormitory create(Dormitory dormitory) {
		return dormitoryRepository.save(dormitory);
	}
	
	public Dormitory findOneById(Long id) {
		Optional<Dormitory> optionalDorm = dormitoryRepository.findById(id);
		if(optionalDorm.isPresent()) {
			return optionalDorm.get();
		}
		return null;
	}
	
//	public void addStudent(Long id, Student student) {
//		Optional<Dormitory> optionalDorm = dormitoryRepository.findById(id);
//		if(optionalDorm.isPresent()) {
//			Dormitory dorm = optionalDorm.get();
//			List<Student> currentStudents = dorm.getStudents();
//			currentStudents.add(student);
//			dorm.setStudents(currentStudents);
//			dormitoryRepository.save(dorm);
//		}
//	}
	
}
