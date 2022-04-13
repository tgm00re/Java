package com.codingdojo.dojosandninjas.mvc.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosandninjas.mvc.models.Dojo;
import com.codingdojo.dojosandninjas.mvc.models.Ninja;
import com.codingdojo.dojosandninjas.mvc.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("dojo") Dojo dojo) {
		List<Dojo> dojoList = dojoService.findAll();
		model.addAttribute("dojoList", dojoList);
		return "index.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		dojoService.createDojo(dojo);
		return "redirect:/";
	}
	
	@RequestMapping("dojo/view/{id}")
	public String viewDojo(@PathVariable("id")Long id, Model model) {
		Dojo dojo = dojoService.findDojoById(id);
		if(dojo == null) {
			return "redirect:/";
		}
		model.addAttribute(dojo);
		return "displaydojo.jsp";
	}
	
}
