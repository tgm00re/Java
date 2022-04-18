package com.codingdojo.rosters.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.rosters.mvc.models.Class;
import com.codingdojo.rosters.mvc.models.Student;
import com.codingdojo.rosters.mvc.services.ClassService;
import com.codingdojo.rosters.mvc.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private ClassService classServ;
	@Autowired
	private StudentService studentServ;
	
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("student") Student student, @ModelAttribute("class") Class newClass) {
		List<Student> studentList = studentServ.findAll();
		List<Class> classList = classServ.findAll();
		model.addAttribute("classList",classList);
		model.addAttribute("studentList", studentList);
		return "index.jsp";
	}
	
	
	@PostMapping("/create/student")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("class", new Class());
			return "index.jsp";
		}
		studentServ.create(student);
		return "redirect:/";
	}
	
	@PostMapping("/create/class")
	public String createClass(@Valid @ModelAttribute("class") Class newClass, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("student", new Student());
			return "index.jsp";
		}
		classServ.create(newClass);
		return "redirect:/";
	}
	
	@RequestMapping("/view/student/{id}")
	public String viewStudent(@PathVariable("id") Long id, Model model) {
		Student s = studentServ.findOneById(id);
		if(s == null) {
			return "redirect:/";
		}
		model.addAttribute("classAddList", classServ.findByStudentsNotContains(s));
		model.addAttribute("classList", classServ.findAllByStudents(s));
		model.addAttribute("student", s);
		return "displaystudent.jsp";
	}
	
	@RequestMapping("/relationship/{studentId}/{classId}")
	public String relationship(@PathVariable("studentId") Long studentId, @PathVariable("classId") Long classId) {
		studentServ.addClass(studentId, classId);
		return "redirect:/view/student/" + studentId;
	}
}
