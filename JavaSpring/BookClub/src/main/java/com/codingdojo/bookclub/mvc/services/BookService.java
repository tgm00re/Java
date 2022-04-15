package com.codingdojo.bookclub.mvc.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.mvc.models.Book;
import com.codingdojo.bookclub.mvc.repositories.BookRepository;


@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	public Book findOneById(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	
	
	
}
