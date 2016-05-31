package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookDao;
import com.example.dao.BookReaderDao;
import com.example.entities.Book;
import com.example.entities.BookReader;

@Service
public class BookReaderServiceImpl implements BookReaderService{
	
	@Autowired
	BookReaderDao bookDao;

	@Override
	public BookReader getBookReaderbyId(long id) {
		return bookDao.getBookReaderbyId(id);
	}

	@Override
	public List<BookReader> getAllBookReader() {
		return bookDao.getAllBookReader();
	}

	@Override
	public void addBookReader(BookReader book) {
		bookDao.addBookReader(book);
	}

	@Override
	public void updateBookReader(BookReader book) {
		bookDao.updateBookReader(book);
	}

	@Override
	public void removeBookReader(BookReader book) {
		bookDao.removeBookReader(book);
	}

	@Override
	public List<BookReader> getAllBookReaderGraph() {
		return bookDao.getAllBookReaderGraph();
	}


}
