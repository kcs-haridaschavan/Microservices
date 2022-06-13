package com.kcsitglobal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kcsitglobal.entity.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {
	public List<Book> findByPriceLessThanEqual(double price);

	public List<Book> findByName(String name);
}
