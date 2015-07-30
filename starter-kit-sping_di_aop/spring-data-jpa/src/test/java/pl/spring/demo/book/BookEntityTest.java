package pl.spring.demo.book;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

public class BookEntityTest {
	
	@Test
	public void shouldCreateBookEntit(){
		BookEntity bookEntity = new BookEntity(1L,"title","athor");
		assertEquals(1L, bookEntity.getId().longValue());
	}
	
	@Test
	public void shouldCreateBookEntitFromBookTo(){
		BookEntity bookEntity = new BookEntity(new BookTo(1L,"title","athor"));
		assertEquals(1L, bookEntity.getId().longValue());
	}
}
