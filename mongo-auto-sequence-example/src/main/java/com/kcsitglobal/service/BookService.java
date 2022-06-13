package com.kcsitglobal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kcsitglobal.entity.Book;
import com.kcsitglobal.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Book save(Book book) {

		return bookRepository.save(book);
	}

	public ResponseEntity<List<Book>> getBooks() {
		return ResponseEntity.ok(bookRepository.findAll(Sort.by(Sort.Direction.ASC, "name")));
	}

	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	public String deleteBook(int id) {
		bookRepository.deleteById(id);
		return "Delete Book Sucessfully";

	}

	public List<Book> getByLessPrice(double price) {
		return bookRepository.findByPriceLessThanEqual(price);
	}

	public List<Book> getBookByName(String name) {
		return bookRepository.findByName(name);
	}

}
