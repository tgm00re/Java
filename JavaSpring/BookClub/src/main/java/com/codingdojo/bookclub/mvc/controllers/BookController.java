package com.codingdojo.bookclub.mvc.controllers;

import java.util.List;

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

import com.codingdojo.bookclub.mvc.models.Book;
import com.codingdojo.bookclub.mvc.models.User;
import com.codingdojo.bookclub.mvc.services.BookService;
import com.codingdojo.bookclub.mvc.services.UserService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	@RequestMapping("/books")
	public String books(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
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
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "newbook.jsp";
		}
		User currentUser = userService.findOneById((Long)session.getAttribute("user_id"));
		book.setUser(currentUser);
		bookService.create(book);
		return "redirect:/books";
	}
	
	
	@RequestMapping("/books/{id}/view") //CHANGE THIS TO /books/{id}
 	public String viewBook(HttpSession session, @PathVariable("id") Long id, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Book book = bookService.findOneById(id);
		if(book == null) {
			return "redirect:/books";
		}
		model.addAttribute("book", book);
		model.addAttribute("user_id", session.getAttribute("user_id"));
		return "viewbook.jsp";
	}
	
	@RequestMapping("/books/{id}/edit") //Change this to /books/{id}/edit
	public String editBook(HttpSession session, @PathVariable("id") Long id, Model model, @ModelAttribute("book") Book book) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Book bookToUpdate = bookService.findOneById(id);
		if(bookToUpdate == null) {
			return "redirect:/books";
		}
		if(bookToUpdate.getUser() != userService.findOneById((Long) session.getAttribute("user_id"))) {
			return "redirect:/";
		}
		model.addAttribute("bookToUpdate", bookToUpdate);
		return "editbook.jsp";
	}
	
	@PostMapping("/books/update/{id}")
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		Book bookToUpdate = bookService.findOneById(id);
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("bookToUpdate", bookToUpdate);
			return "editbook.jsp";
		}
		bookToUpdate.setTitle(book.getTitle());
		bookToUpdate.setAuthorName(book.getAuthorName());
		bookToUpdate.setDescription(book.getDescription());
		bookService.update(bookToUpdate);
		return "redirect:/books";
		
	}
	
	
	
	
}
