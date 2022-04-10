package com.example.demo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.mvc.models.Book;
import com.example.demo.mvc.repositories.BookRepository;

@Service
public class BookService {
	//adding the book repository as a dependency.
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	//Returns all the books
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	//creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	public Book updateBook(long id, String title, String description, String language, int pages) {
		Book bookToUpdate = this.findBook(id);
		if(bookToUpdate == null) {
			return null;
		}
		bookToUpdate.setTitle(title);
		bookToUpdate.setDescription(description);
		bookToUpdate.setLanguage(language);
		bookToUpdate.setPages(pages);
		return bookRepository.save(bookToUpdate);
	}
	
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}
	
	//Retrieves aOptional<T>
	public Book findBook(long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
}
