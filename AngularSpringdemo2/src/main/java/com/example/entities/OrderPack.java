package com.example.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="OrderPack")
public class OrderPack {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="bookCount")
	private int bookCount;
	@Column(name="borrowDate")
	private Date borrowDate;
	@Column(name="returnDate")
	private Date returnDate;
	
//	@OneToOne
	@ManyToOne
	@JoinColumn(name = "bookReader_orderPack_id")
	@JsonBackReference
	private BookReader bookReader;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "orderPack", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Book> books;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public BookReader getBookReader() {
		return bookReader;
	}

	public void setBookReader(BookReader bookReader) {
		this.bookReader = bookReader;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
