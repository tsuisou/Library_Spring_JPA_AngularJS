package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Book;
import com.example.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/book")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}

	@RequestMapping(value = "/book",method= RequestMethod.POST)
	public void addBook(@RequestBody Book book){
		System.out.println("Wchodzę w add");
		System.out.println("book " + book.getTitle());
		bookService.addBook(book);
	}
	
	@RequestMapping(value="/book/{id}")
	public Book getBookById(@PathVariable("id") long id){
		System.out.println("Wchodzę w getBook");
		return bookService.getBookbyId(id);
	}
	
	@RequestMapping(value="/book/{id}",method=RequestMethod.PUT)
	public void updateBook(@PathVariable("id") long id,@RequestBody Book book){	
		System.out.println("Wchodzę w update");
		bookService.updateBook(book);
	}
	
	@RequestMapping(value="/book/{id}",method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") long id){
		System.out.println("Wchodzę w delete");
		Book book = bookService.getBookbyId(id);
		bookService.removeBook(book);
	}
	
	@RequestMapping(value="/bookWithoutId")
	public List<Book> getAllBooksWithoutId(){
		System.out.println("Wchodzę w withoutId");
		return bookService.getAllBooksWithoutId();
	}
	
	@RequestMapping(value="/bookReaderBooks/{id}")
	public List<Book> getAllBooksOneBookReader(@PathVariable long id){
		return bookService.getAllBooksOneBookReader(id);
	}
}
