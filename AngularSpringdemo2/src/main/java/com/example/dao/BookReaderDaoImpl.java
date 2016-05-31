package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.entities.Book;
import com.example.entities.BookReader;

@Repository
@Transactional
public class BookReaderDaoImpl implements BookReaderDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public BookReader getBookReaderbyId(long id) {
		return entityManager.find(BookReader.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookReader> getAllBookReader() {
		return entityManager.createQuery(
				"from BookReader").getResultList();
	}
	@Override
	public Long bookReaderCount(){
//		return (Long) entityManager.createQuery("select count(*) from BookReader").getSingleResult();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<BookReader> root = cq.from(BookReader.class);
		cq.select(cb.count(root));
		cq.where(cb.equal(root.get("readerName"), cb.parameter(String.class,"parametr")));
		TypedQuery<Long> tq = entityManager.createQuery(cq);
		tq.setParameter("parametr", "Tomek");
		return tq.getSingleResult();
	}

	@Override
	public void addBookReader(BookReader bookReader) {
		entityManager.persist(bookReader);
	}

	@Override
	public void updateBookReader(BookReader bookReader) {
		entityManager.merge(bookReader);
		
	}

	@Override
	public void removeBookReader(BookReader bookReader) {
		if(entityManager.contains(bookReader)){
			entityManager.remove(bookReader);
		}
	}

	@Override
	public List<BookReader> getAllBookReaderGraph() {
		return entityManager.createNamedQuery("BookReader.all",BookReader.class)
		.setHint("javax.persistence.fetchgraph", "graph.BookReader")
		.getResultList();
	}
	
	

}
