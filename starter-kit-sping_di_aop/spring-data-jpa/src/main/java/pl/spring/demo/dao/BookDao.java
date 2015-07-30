package pl.spring.demo.dao;

import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface BookDao {

    List<BookEntity> findAll();

    List<BookEntity> findBookByTitle(String title);

    List<BookEntity> findBooksByAuthor(String author);

    BookEntity save(BookEntity bookEntity);
}
