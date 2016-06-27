package com.example.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookDao;
import com.example.dao.OrederPackDao;
import com.example.entities.Book;
import com.example.entities.OrderPack;
import com.example.services.OrderPackService;

@Service
public class OrderPackServiceImpl implements OrderPackService{
	
	@Autowired
	OrederPackDao orderPackDao;

	@Override
	public OrderPack getOrderPackbyId(long id) {
		return orderPackDao.getOrderPackbyId(id);
	}

	@Override
	public List<OrderPack> getAllOrderPacks() {
		return orderPackDao.getAllOrderPacks();
	}

	@Override
	public void addOrderPack(OrderPack orderPack) {
		orderPackDao.addOrderPack(orderPack);
	}

	@Override
	public void updateOrderPack(OrderPack orderPack) {
		orderPackDao.updateOrderPack(orderPack);
	}

	@Override
	public void removeOrderPack(OrderPack orderPack) {
		orderPackDao.removeOrderPack(orderPack);
	}

//	@Override
//	public List<Book> getAllBooksWithoutId() {
//		return bookDao.getAllBooksWithoutId();
//	}

}
