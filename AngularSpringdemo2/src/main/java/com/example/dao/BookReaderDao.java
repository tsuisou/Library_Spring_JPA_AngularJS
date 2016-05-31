package com.example.dao;

import java.util.List;

import com.example.entities.Book;
import com.example.entities.BookReader;

public interface BookReaderDao {

	BookReader getBookReaderbyId(long id);
	
	List<BookReader> getAllBookReader();
	
	void addBookReader(BookReader bookReader);
	
	void updateBookReader(BookReader bookReader);
	
	void removeBookReader(BookReader bookReader);
	
	Long bookReaderCount();
	
	List<BookReader> getAllBookReaderGraph();
}
