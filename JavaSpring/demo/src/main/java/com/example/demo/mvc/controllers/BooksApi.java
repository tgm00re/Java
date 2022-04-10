package com.example.demo.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mvc.models.Book;
import com.example.demo.mvc.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> index(){
		return bookService.allBooks();
	}
	
	@RequestMapping(value="/api/books/create", method=RequestMethod.POST)
		public Book create(
				@RequestParam(value="title") String title,
				@RequestParam(value="description") String description,
				@RequestParam(value="language") String language,
				@RequestParam(value="pages") Integer pages
				){
					Book book = new Book(title, description, language, pages);
					return bookService.createBook(book);
		}
	
	@RequestMapping(value="/api/books/update/{id}", method=RequestMethod.PUT)
	public Book update(
			@PathVariable("id") long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="pages") Integer pages
			) {
		return bookService.updateBook(id, title, description, language, pages);
	}
	
		@RequestMapping(value="/api/books/delete/{id}", method=RequestMethod.DELETE)
		public void destroy(@PathVariable("id") Long id) {
			bookService.deleteBook(id);
		}
				
}
