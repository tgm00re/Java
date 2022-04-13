package com.codingdojo.studentroster.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.studentroster.mvc.models.Dormitory;
import com.codingdojo.studentroster.mvc.models.Student;
import com.codingdojo.studentroster.mvc.services.DormitoryService;
import com.codingdojo.studentroster.mvc.services.StudentService;

@Controller
public class DormitoryController {
	private final DormitoryService dormServ;
	private final StudentService studentServ;
	public DormitoryController(DormitoryService dormServ, StudentService studentServ) {
		this.dormServ = dormServ;
		this.studentServ = studentServ;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("dormitory") Dormitory dormitory, Model model) {
		List<Dormitory> dormitoryList = dormServ.findAll();
		model.addAttribute("dormList", dormitoryList);
		return "index.jsp";
	}
	
	@PostMapping("/dorm/create")
	public String createDorm(@Valid @ModelAttribute("dormitory") Dormitory dormitory, BindingResult result, Model model) {
		if(!result.hasErrors()) {
			dormServ.create(dormitory);
			return "redirect:/";
		}
		List<Dormitory> dormitoryList = dormServ.findAll();
		model.addAttribute("dormList", dormitoryList);
		return "index.jsp";
	}
	
	@RequestMapping("/dorm/view/{id}")
	public String viewDorm(@PathVariable("id") Long id, Model model) {
		Dormitory dorm = dormServ.findOneById(id);
		if(dorm == null) {
			return "redirect:/";
		}
		List<Student> studentWithoutDormList = studentServ.findStudentsWithoutDormitory();
		model.addAttribute("studentWithoutDormList", studentWithoutDormList);
		model.addAttribute("dorm", dorm);
		return "displaydorm.jsp";
	}
	
	@PostMapping("/dorm/add/student/{dormId}")
	public String addStudent(@PathVariable("dormId") Long dormId, @RequestParam(value="studentId") Long studentId) {
		studentServ.addStudentToDormitory(studentId, dormId);
		return "redirect:/dorm/view/" + dormId;
	}
	
	@RequestMapping("/removefromdorm/{dormId}/{studentId}")
	public String removeFromDorm(@PathVariable("dormId") Long dormId, @PathVariable("studentId") Long studentId) {
		studentServ.removeStudentFromDormitory(studentId);
		return "redirect:/dorm/view/" + dormId;
		
	}
}
