package com.example.demo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mvc.models.Book;
import com.example.demo.mvc.services.BookService;

@Controller
public class BooksController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> bookList = bookService.allBooks();
		model.addAttribute("bookList", bookList);
		return "index.jsp";
	}
	
	@RequestMapping("/books/{id}")
	public String displayOne(Model model, @PathVariable("id") long id) {
		Book book = bookService.findBook(id);
		if(book == null) {
			return "redirect:/books";
		}
		model.addAttribute(book);
		
		return "displayOne.jsp";
	}

}
