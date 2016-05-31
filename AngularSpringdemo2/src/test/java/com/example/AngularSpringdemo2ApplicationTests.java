package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
//import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.dao.BookDao;
import com.example.entities.Book;
import com.example.entities.BookReader;
import com.example.entities.OrderPack;

import static junit.framework.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AngularSpringdemo2Application.class)
@WebAppConfiguration
public class AngularSpringdemo2ApplicationTests {
	
	@Mock
	BookDao bookDao;
	
	@Autowired
	EntityManager em;
	
	@Before
	public void setup(){
		bookDao = mock(BookDao.class);
		List<Book> lista = new ArrayList<Book>();
		for (int i = 0; i < 10; i++) {
			Book book = new Book();
			book.setId(i);
			book.setTitle("title " + i);
			lista.add(book);
		}
		when(bookDao.getAllBooks()).thenReturn(lista);
	}

	@Test
	public void count() {
		List<Book> resultList = bookDao.getAllBooks();
		assertEquals(10, resultList.size());
		assertNotNull(resultList);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getElement() {
		List<Book> resultList = bookDao.getAllBooks();
		assertSame("równają się" , 5, 5);
		for (Book book : resultList) {
			if (book.getId() == 5)
			assertEquals("równe", "title 5", book.getTitle());
		}
	}
	
	@Test
	public void getAllBooksFromBookReader(){
		List<Book> resultList = em.createQuery("select b from Book b join b.orderPack o join o.bookReader r where r.id = :number", Book.class)
				.setParameter("number", 1L)
				.getResultList();
		System.out.println(resultList.size());
	}

}
