package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Book;
import com.example.entities.OrderPack;
import com.example.services.BookService;
import com.example.services.OrderPackService;

@RestController
public class OrderPackController {
	
	@Autowired
	OrderPackService orderpackService;
	
	@RequestMapping("/orderPack")
	public List<OrderPack> getAllBooks(){
		return orderpackService.getAllOrderPacks();
	}

	@RequestMapping(value = "/orderPack",method= RequestMethod.POST)
	public void addOrderPack(@RequestBody OrderPack orderPack){
//		System.out.println("Wchodzę w add");
//		System.out.println("book " + book.getTitle());
		orderpackService.addOrderPack(orderPack);
		System.out.println("orderPack " + orderPack.getId());
	}
	
	@RequestMapping(value="/orderPack/{id}")
	public OrderPack getOrderPackById(@PathVariable("id") long id){
//		System.out.println("Wchodzę w getBook");
		return orderpackService.getOrderPackbyId(id);
	}
	
	@RequestMapping(value="/orderPack/{id}",method=RequestMethod.PUT)
	public void updateOrderPack(@PathVariable("id") long id,@RequestBody OrderPack orderPack){	
//		System.out.println("Wchodzę w update");
//		System.out.println("id " + id);
//		OrderPack oldBook = orderpackServicmanage.getOrderPackbyId(id);
//		System.out.println(book.toString());
//		System.out.println("Tytuł " + book.getTitle());
//		oldBook.setTitle(book.getTitle());
//		oldBook.setCategory(book.getCategory());
		orderpackService.updateOrderPack(orderPack);
	}
	
	@RequestMapping(value="/orderPack/{id}",method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") long id){
//		System.out.println("Wchodzę w delete");
		OrderPack orderPack = orderpackService.getOrderPackbyId(id);
		orderpackService.removeOrderPack(orderPack);
	}
	
//	@RequestMapping(value="/bookWithoutId")
//	public List<Book> getAllBooksWithoutId(){
//		System.out.println("Wchodzę w withoutId");
//		return orderpackService.getAllBooksWithoutId();
//	}
}
