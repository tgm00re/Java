package com.codingdojo.studentroster.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.studentroster.mvc.models.Student;
import com.codingdojo.studentroster.mvc.services.StudentService;

@Controller
public class StudentController {
	private final StudentService studentServ;
	
	public StudentController(StudentService studentServ) {
		this.studentServ = studentServ;
	}
	
	@RequestMapping("/student")
	public String student(@ModelAttribute("student") Student student) {
		return "student.jsp";
	}
	
	@PostMapping("/student/create")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "student.jsp";
		}
		studentServ.create(student);
		return "redirect:/student";
	}
	
	
}
