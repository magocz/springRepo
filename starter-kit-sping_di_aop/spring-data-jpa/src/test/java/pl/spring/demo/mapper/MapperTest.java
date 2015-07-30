package pl.spring.demo.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

public class MapperTest {

	private BookMaper bookMaper = new BookMaper();

	@Test
	public void shouldMapBookToToBookEntnity() {
		BookEntity bookEntity = bookMaper.mapp(new BookTo(1L, "title", "firstName lastName"));
		assertEquals(bookEntity.getAthor().toString(), "firstName lastName");
	}

	@Test
	public void shouldMapBookEntnityToBookTo() {
		BookTo bookTo = bookMaper.mapp(new BookEntity(1L, "title", "firstName lastName"));
		assertEquals(bookTo.getAuthors(), "firstName lastName");
	}

	@Test
	public void shouldMapBookEntnityToBookTo_List() {
		List<BookEntity> bookEntityList = new ArrayList<BookEntity>();

		bookEntityList.add(new BookEntity(1L, "Romeo i Julia", "Wiliam Szekspir"));
		bookEntityList.add(new BookEntity(2L, "Opium w rosole", "Hanna Ożogowska"));
		bookEntityList.add(new BookEntity(3L, "Przygody Odyseusza", "Jan Parandowski"));
		bookEntityList.add(new BookEntity(4L, "Awantura w Niekłaju", "Edmund Niziurski"));
		bookEntityList.add(new BookEntity(5L, "Pan Samochodzik i Fantomas", "Zbigniew Nienacki"));
		bookEntityList.add(new BookEntity(6L, "Zemsta", "Aleksander Fredro"));

		assertEquals(6, bookMaper.mappBookEntitnyToBookTo(bookEntityList).size());
		assertEquals(6L, bookMaper.mappBookEntitnyToBookTo(bookEntityList).get(5).getId().longValue());
		assertEquals("Pan Samochodzik i Fantomas", bookMaper.mappBookEntitnyToBookTo(bookEntityList).get(4).getTitle());
		assertEquals("Edmund Niziurski", bookMaper.mappBookEntitnyToBookTo(bookEntityList).get(3).getAuthors());

	}
	
	@Test
	public void shouldMapBookToToBookEntity_List() {
		List<BookTo> bookToList = new ArrayList<BookTo>();

		bookToList.add(new BookTo(1L, "Romeo i Julia", "Wiliam Szekspir"));
		bookToList.add(new BookTo(2L, "Opium w rosole", "Hanna Ożogowska"));
		bookToList.add(new BookTo(3L, "Przygody Odyseusza", "Jan Parandowski"));
		bookToList.add(new BookTo(4L, "Awantura w Niekłaju", "Edmund Niziurski"));
		bookToList.add(new BookTo(5L, "Pan Samochodzik i Fantomas", "Zbigniew Nienacki"));
		bookToList.add(new BookTo(6L, "Zemsta", "Aleksander Fredro"));

		assertEquals(6, bookMaper.mappBookToToBookEntity(bookToList).size());
		assertEquals(6L, bookMaper.mappBookToToBookEntity(bookToList).get(5).getId().longValue());
		assertEquals("Pan Samochodzik i Fantomas", bookMaper.mappBookToToBookEntity(bookToList).get(4).getTitle());
		assertEquals("Edmund Niziurski", bookMaper.mappBookToToBookEntity(bookToList).get(3).getAthor());

	}

}
