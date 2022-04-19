package com.codingdojo.projectmanager.mvc.controllers;

import java.util.List;

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

import com.codingdojo.projectmanager.mvc.models.LoginUser;
import com.codingdojo.projectmanager.mvc.models.Project;
import com.codingdojo.projectmanager.mvc.models.User;
import com.codingdojo.projectmanager.mvc.services.ProjectService;
import com.codingdojo.projectmanager.mvc.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private ProjectService projectServ;
	
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user, @ModelAttribute("loginUser") LoginUser loginUser, HttpSession session) {
		if(session.getAttribute("user_id") != null) {
			return "redirect:/dashboard";
		}
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		userServ.registerUser(user, result);
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			System.out.println("Errors were found, returning index page.");
			return "index.jsp";
		}
		//Registration was valid
		//Hash password
		String newPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(newPass);
		//Store in db
		User newUser = userServ.create(user);
		//Add to session
		session.setAttribute("user_id", newUser.getId());
		session.setAttribute("user_name", newUser.getFirstName());
		//Redirect
		return "redirect:/dashboard";
		
	}
	
	
	
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User user = userServ.validateUserLogin(loginUser, result);
		if(result.hasErrors()) {
			System.out.println("Errors were found, returning index page.");
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		//Login was valid
		//add to session
		session.setAttribute("user_id", user.getId());
		session.setAttribute("user_name", user.getFirstName());
		//Redirect
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		List<Project> projectList = projectServ.findAll();
		User user = userServ.findOneById((Long) session.getAttribute("user_id"));
		model.addAttribute("user", user);
		model.addAttribute("projectList", projectList);
		model.addAttribute("user_id",  (Long) session.getAttribute("user_id"));
		return "dashboard.jsp";
	}
	
	
}
