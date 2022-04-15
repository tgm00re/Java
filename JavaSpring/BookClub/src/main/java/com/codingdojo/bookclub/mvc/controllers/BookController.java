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

import com.codingdojo.bookclub.mvc.models.Book;
import com.codingdojo.bookclub.mvc.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping("/books")
	public String books(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("user_name",session.getAttribute("user_name"));
		return "books.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "newbook.jsp";
	}
	
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newbook.jsp";
		}
		bookService.create(book);
		return "redirect:/books";
	}
	
	
	@RequestMapping("/books/view") //CHANGE THIS TO /books/{id}
 	public String viewBook(HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "viewbook.jsp";
	}
	
	@RequestMapping("/books/edit") //Change this to /books/{id}/edit
	public String editBook(HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "editbook.jsp";
	}
	
	
}
