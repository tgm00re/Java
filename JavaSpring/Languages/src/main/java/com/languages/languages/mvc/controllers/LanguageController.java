package com.languages.languages.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.languages.languages.mvc.models.Language;
import com.languages.languages.mvc.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Language> languageList = languageService.findAll();
		model.addAttribute("languageList", languageList);
		return "index.jsp";
	}
	
	@RequestMapping("/create")
	public String create(@ModelAttribute("language") Language language) {
		return "create.jsp";
	}
	
	@PostMapping("/process/create")
	public String processCreate(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/create";
		}
		languageService.create(language);
		return "redirect:/";
	}
	
	@RequestMapping("/languages/view/{id}") //Be sure to add pathvariable to link
	public String displayOne(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findOneById(id);
		if(language == null) {
			return "redirect:/";
		}
		model.addAttribute("language",language);
		return "displayOne.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}") //Be sure to add pathvariable to link
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findOneById(id);
		if(language == null) {
			return "redirect:/";
		}
		model.addAttribute("language",language);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/process/edit/{id}", method=RequestMethod.POST)
	public String processEdit(@Valid @ModelAttribute("language") Language language, @PathVariable("id") Long id, BindingResult result) {
		Language languageToUpdate = languageService.findOneById(id);
		if(languageToUpdate == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "redirect:/process/edit" + id;
		}
		languageService.update(id, language.getName(), language.getCreator(), language.getVersion());
		return "redirect:/";
	}
	
	
	@RequestMapping("/languages/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		languageService.delete(id);
		return "redirect:/";
	}
}
