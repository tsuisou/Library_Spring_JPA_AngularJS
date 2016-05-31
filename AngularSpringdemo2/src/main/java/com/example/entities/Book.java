package com.example.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name ="Book")
public class Book {
	
	@Id
	@GeneratedValue
	private long Id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;
	
	@Column(name= "bookBorrowDate")
	private Date bookBorrowDate;
	
	@Column(name="returnDateBook")
	private Date returnDateBook;
	
	@Column(name = "available")
	private Boolean available;
	
	@JsonProperty(value="grupa_id")
	@ManyToOne
	@JoinColumn(name = "orderPack_id")
	@JsonBackReference
	private OrderPack orderPack;

	public long getId() {	
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Date getBookBorrowDate() {
		return bookBorrowDate;
	}

	public void setBookBorrowDate(Date bookBorrowDate) {
		this.bookBorrowDate = bookBorrowDate;
	}

	public OrderPack getOrderPack() {
		return orderPack;
	}

	public void setOrderPack(OrderPack orderPack) {
		this.orderPack = orderPack;
	}

	public Date getReturnDateBook() {
		return returnDateBook;
	}

	public void setReturnDateBook(Date returnDateBook) {
		this.returnDateBook = returnDateBook;
	}
}
