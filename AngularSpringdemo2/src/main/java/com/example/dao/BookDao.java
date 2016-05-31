package com.example.dao;

import java.util.List;

import com.example.entities.Book;

public interface BookDao {

	Book getBookbyId(long id);
	
	List<Book> getAllBooks();
	
	void addBook(Book book);
	
	void updateBook(Book book);
	
	void removeBook(Book book);
	
	List<Book> getAllBooksWithoutId();
	
	List<Book> getAllBooksOneBookReader(long id);
}
