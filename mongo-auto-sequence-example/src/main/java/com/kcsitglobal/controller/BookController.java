package com.kcsitglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.entity.Book;
//import com.kcsitglobal.repository.BookRepository;
import com.kcsitglobal.service.BookService;
import com.kcsitglobal.service.SequenceGeneratorService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private SequenceGeneratorService service;
	@Autowired
	BookService bookService;

	@PostMapping("/savebook")
	public Book save(@RequestBody Book book) {
		book.setId(service.getSequenceNumber(Book.SEQUENCE_NAME));

		// return repository.save(book);
		return bookService.save(book);
	}

	@GetMapping("/get-books")
	public ResponseEntity<List<Book>> getBooks() {

		// return ResponseEntity.ok(repository.findAll(Sort.by(Sort.Direction.ASC,
		// "name")));
		return bookService.getBooks();
	}

	@PutMapping("/update-book")
	public Book updateBook(@RequestBody Book book) {
		// return repository.save(book);
		return bookService.updateBook(book);

	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable int id) {
		// repository.deleteById(id);
		// return "Book Deleted sucessfully";
		return bookService.deleteBook(id);

	}

	@GetMapping("getByLessPrice/{price}")
	public List<Book> getByLessPrice(@PathVariable double price) {
		// return repository.findByPriceLessThanEqual(price);
		return bookService.getByLessPrice(price);
	}

	@GetMapping("/{name}")
	public List<Book> getBookByName(@PathVariable String name) {
		// return repository.findByName(name);
		return bookService.getBookByName(name);
	}
}
