package com.codingdojo.dojosandninjas.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosandninjas.mvc.models.Dojo;
import com.codingdojo.dojosandninjas.mvc.models.Ninja;
import com.codingdojo.dojosandninjas.mvc.services.DojoService;
import com.codingdojo.dojosandninjas.mvc.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	
	@RequestMapping("/ninja")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojoList = dojoService.findAll();
		model.addAttribute("dojoList", dojoList);
		return "ninja.jsp";
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/ninja";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/ninja";
	}
}
