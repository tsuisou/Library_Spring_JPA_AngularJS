package com.example.services;

import java.util.List;

import com.example.entities.Book;
import com.example.entities.BookReader;

public interface BookReaderService {

BookReader getBookReaderbyId(long id);
	
	List<BookReader> getAllBookReader();
	
	void addBookReader(BookReader bookReader);
	
	void updateBookReader(BookReader bookReader);
	
	void removeBookReader(BookReader bookReader);
	
	List<BookReader> getAllBookReaderGraph();
	
	
}
