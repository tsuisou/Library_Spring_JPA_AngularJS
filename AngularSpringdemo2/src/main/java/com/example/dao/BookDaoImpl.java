package com.example.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.entities.Book;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Book getBookbyId(long id) {
		return entityManager.find(Book.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		return entityManager.createQuery("from Book").getResultList();
	}

	@Override
	public void addBook(Book book) {
		entityManager.persist(book);
	}

	@Override
	public void updateBook(Book book) {
		entityManager.merge(book);

	}

	@Override
	public void removeBook(Book book) {
		if (entityManager.contains(book)) {
			System.out.println("usuwam");
			entityManager.remove(book);
		}
	}

	@Override
	public List<Book> getAllBooksWithoutId() {
		return entityManager.createQuery("from Book b where b.orderPack.id is null", Book.class).getResultList();
	}

	// @Override
	// public List<Book> getAllBooksWithBorrowDate() {
	// return entityManager.createQuery("select b, c.borrowDate from Book b join
	// b.order c").getResultList();
	// }
	@Override
	public List<Book> getAllBooksOneBookReader(long id){
		List<Book> resultList = entityManager.createQuery("select b from Book b join b.orderPack o join o.bookReader r where r.id = :number", Book.class)
		.setParameter("number", id)
		.getResultList();
		return resultList;
	}

}
