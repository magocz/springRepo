package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@Service
public class BookMaper {
	public BookMaper(){
		
	}
	public List<BookTo> mappBookEntitnyToBookTo(List<BookEntity> bookEntities){
		List<BookTo> mappedList = new ArrayList<BookTo>(); 
		for(BookEntity bookEntity : bookEntities){
			mappedList.add(new BookTo(bookEntity));
		}
		return mappedList;
	}
	
	public List<BookEntity> mappBookToToBookEntity(List<BookTo> bookTos){
		List<BookEntity> mappedList = new ArrayList<BookEntity>(); 
		for(BookTo bookTo : bookTos){
			mappedList.add(new BookEntity(bookTo));
		}
		return mappedList;
	}

	public BookTo mapp(BookEntity bookEntity) {
		return new BookTo(bookEntity);
	}
	
	public BookEntity mapp(BookTo bookTo) {
		return new BookEntity(bookTo);
	}
}
