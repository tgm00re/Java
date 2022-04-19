package com.codingdojo.projectmanager.mvc.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.projectmanager.mvc.models.Project;
import com.codingdojo.projectmanager.mvc.models.Task;
import com.codingdojo.projectmanager.mvc.models.User;
import com.codingdojo.projectmanager.mvc.services.ProjectService;
import com.codingdojo.projectmanager.mvc.services.TaskService;
import com.codingdojo.projectmanager.mvc.services.UserService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectServ;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private TaskService taskServ;

	@RequestMapping("/projects/new")
	public String newProject(HttpSession session, @ModelAttribute("project") Project project) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "newproject.jsp";
	}
	
	@PostMapping("/projects/create")
	public String createProject(HttpSession session, @Valid @ModelAttribute("project") Project project, BindingResult result) {
		if(result.hasErrors()) {
			return "newproject.jsp";
		}
		User user = userServ.findOneById((Long) session.getAttribute("user_id"));
		project.setLead(user);
		projectServ.create(project);
		return "redirect:/dashboard";
	}
	
	
	@RequestMapping("/projects/edit/{projectId}")
	public String editProject(HttpSession session, @PathVariable("projectId") Long id, Model model, @ModelAttribute("project") Project proj) {
		Project currentProject = projectServ.findOneById(id);
		if(session.getAttribute("user_id") == null || currentProject == null) {
			return "redirect:/";
		}
		if((Long) session.getAttribute("user_id") != currentProject.getLead().getId()) {
			return "redirect:/dashboard";
		}
		model.addAttribute("currentProject", currentProject);
		return "editproject.jsp";
	}
	
	@PostMapping("/projects/update/{projectId}")
	public String updateProject(@Valid @ModelAttribute("project") Project proj, BindingResult result, Model model, @PathVariable("projectId") Long id) {
		Project currentProject = projectServ.findOneById(id);
		if(result.hasErrors()) {
			model.addAttribute("currentProject", currentProject);
			return "editproject.jsp";
		}
		currentProject.setTitle(proj.getTitle());
		currentProject.setDescription(proj.getDescription());
		currentProject.setDueDate(proj.getDueDate());
		projectServ.update(currentProject);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/projects/view/{projectId}")
	public String viewProject(HttpSession session, @PathVariable("projectId") Long id, Model model) {
		Project project = projectServ.findOneById(id);
		if(session.getAttribute("user_id") == null || project == null) {
			return "redirect:/";
		}
		model.addAttribute("project", project);
		model.addAttribute("user_id", (Long) session.getAttribute("user_id"));
		return "viewproject.jsp";
	}
	
	@RequestMapping("/projects/tasks/{projectId}")
	public String projectTasks(HttpSession session, @ModelAttribute("task") Task task, @PathVariable("projectId") Long projectId, Model model) {
		Project project = projectServ.findOneById(projectId);
		if(session.getAttribute("user_id") == null || project == null) {
			return "redirect:/";
		}
		model.addAttribute("project", project);
		return "projecttasks.jsp";
	}
	
	@PostMapping("/tasks/create/{projectId}")
	public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable("projectId") Long projectId, HttpSession session, Model model) {
		Project project = projectServ.findOneById(projectId);
		if(result.hasErrors()) {
			model.addAttribute("project", project);
			return "projecttasks.jsp";
		}
		task.setCreatorName((String) session.getAttribute("user_name"));
		task.setProject(project);
		taskServ.create(task);
		return "redirect:/projects/tasks/" + projectId;
	}
	
	@RequestMapping("/projects/addmember/{projectId}")
	public String addMember(@PathVariable("projectId") Long id, HttpSession session) {
		Project project = projectServ.findOneById(id);
		User currentUser = userServ.findOneById((Long) session.getAttribute("user_id"));
		if(currentUser == null || project == null) {
			return "redirect:/";
		}
		if(currentUser.getProjects().contains(project)) {
			return "redirect:/dashboard";
		}
		currentUser.getProjects().add(project);
		userServ.update(currentUser);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/projects/removemember/{projectId}")
	public String removeMember(@PathVariable("projectId") Long id, HttpSession session) {
		Project project = projectServ.findOneById(id);
		User currentUser = userServ.findOneById((Long) session.getAttribute("user_id"));
		if(currentUser == null || project == null) {
			return "redirect:/";
		}
		if(!currentUser.getProjects().contains(project)) {
			return "redirect:/dashboard";
		}
		currentUser.getProjects().remove(project);
		userServ.update(currentUser);
		return "redirect:/dashboard";	
	}
	
	@RequestMapping("/projects/delete/{projectId}")
	public String deleteProject(@PathVariable("projectId") Long id, HttpSession session) {
		Project project = projectServ.findOneById(id);
		User currentUser = userServ.findOneById((Long) session.getAttribute("user_id"));
		if(currentUser == null || project == null) {
			return "redirect:/";
		}
		if(!project.getLead().equals(currentUser)) {
			return "redirect:/logout";
		}
		projectServ.delete(id);
		return "redirect:/dashboard";
	}
	
	
}
