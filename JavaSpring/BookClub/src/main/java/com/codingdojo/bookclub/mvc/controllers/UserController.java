package com.codingdojo.bookclub.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.mvc.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/books")
	public String books() {
		return "books.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook() {
		return "newbook.jsp";
	}
	
	@RequestMapping("/books/view") //CHANGE THIS TO /books/{id}
 	public String viewBook() {
		return "viewbook.jsp";
	}
	
	@RequestMapping("/books/edit") //Change this to /books/{id}/edit
	public String editBook() {
		return "editbook.jsp";
	}
}
