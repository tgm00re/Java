package com.codingdojo.rosters.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.rosters.mvc.models.Class;
import com.codingdojo.rosters.mvc.services.ClassService;
import com.codingdojo.rosters.mvc.services.StudentService;

@Controller
public class ClassController {

	@Autowired
	private ClassService classServ;
	
	@Autowired
	private StudentService studentServ;

	@RequestMapping("/view/class/{id}")
	public String viewClass(@PathVariable("id") Long id, Model model) {
		Class c = classServ.findOneById(id);
		if(c == null) {
			return "redirect:/";
		}
		
		model.addAttribute("oneClass", c);
		model.addAttribute("studentsList", studentServ.findAllByStudents(c));
		
		return "displayclass.jsp";
	}
}
