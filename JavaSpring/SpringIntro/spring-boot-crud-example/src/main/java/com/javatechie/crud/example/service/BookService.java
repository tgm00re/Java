package com.javatechie.crud.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.model.Book;
import com.javatechie.crud.example.repository.BookRepository;

@Configuration
@EnableJpaRepositories("com.javatechie.crud.example.repository")
@EntityScan("com.javatechie.crud.example.model")
@Service
public class BookService {
	//Adding the book repository as a dependency
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	//Returns all the books
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	//Create/update a book - same method is used for both.
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}
	
	public Book updateBook(long id, String title, String description, String language, int pages) {
		Book b = new Book(id, title, description, language, pages);
		return bookRepository.save(b);
	}
	
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}
	
}
