package com.codingdojo.loginandregistration.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.loginandregistration.mvc.models.LoginUser;
import com.codingdojo.loginandregistration.mvc.models.User;
import com.codingdojo.loginandregistration.mvc.services.UserServ;

@Controller
public class UserController {
	@Autowired
	private UserServ userServ;
	
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("user_id") != null) {
			return "redirect:/dashboard";
		}
		model.addAttribute("user", new User());
        model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		userServ.register(user, result);
		if(result.hasErrors()) {
	        model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		String hasedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hasedPassword);
		User newUser = userServ.createUser(user);
		session.setAttribute("user_id", newUser.getId());
		session.setAttribute("user_name", newUser.getUsername());
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, HttpSession session, Model model) {
		System.out.println("Login route");
		User user = userServ.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		session.setAttribute("user_id", user.getId());
		session.setAttribute("user_name", user.getUsername());
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("user_name", session.getAttribute("user_name"));
		model.addAttribute("user_id", session.getAttribute("user_id"));
		return "dashboard.jsp";
	}
}
