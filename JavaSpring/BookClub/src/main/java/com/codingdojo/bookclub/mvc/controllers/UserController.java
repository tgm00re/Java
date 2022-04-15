package com.codingdojo.bookclub.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.mvc.models.LoginUser;
import com.codingdojo.bookclub.mvc.models.User;
import com.codingdojo.bookclub.mvc.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("user_id") != null) {
			return "redirect:/books";
		}
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		userService.register(user, result);
		//Check for errors
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		//Else, everything is good to go!
		//Add to session
		User newUser = userService.create(user);
		session.setAttribute("user_id", newUser.getId());
		session.setAttribute("user_name", newUser.getName());
		return "redirect:/books";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		//Call login function
		User user = userService.login(loginUser, result);
		//Check for errors
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		
		//Everything good to go!
		//Add to session
		session.setAttribute("user_id", user.getId());
		session.setAttribute("user_name", user.getName());
		return "redirect:/books";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
