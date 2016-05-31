package com.example.services;

import java.util.List;

import com.example.entities.Book;
import com.example.entities.OrderPack;

public interface OrderPackService {

	OrderPack getOrderPackbyId(long id);
	
	List<OrderPack> getAllOrderPacks();
	
	void addOrderPack(OrderPack orderPack);
	
	void updateOrderPack(OrderPack orderPack);
	
	void removeOrderPack(OrderPack orderPack);
	
//	List<Book> getAllBooksWithoutId();
	
}
