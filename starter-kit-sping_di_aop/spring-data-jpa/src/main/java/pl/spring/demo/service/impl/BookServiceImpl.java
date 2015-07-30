package pl.spring.demo.service.impl;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.mapper.BookMaper;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
    private BookDao bookDao;
	
	@Autowired
	private BookMaper bookMaper;

    @Override
    public List<BookTo> findAllBooks() {
        return bookMaper.mappBookEntitnyToBookTo(bookDao.findAll());
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {
        return bookMaper.mappBookEntitnyToBookTo(bookDao.findBookByTitle(title));
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
        return bookMaper.mappBookEntitnyToBookTo(bookDao.findBooksByAuthor(author));
    }

    @Override
    public BookTo saveBook(BookTo book) {
        return bookMaper.mapp(bookDao.save(bookMaper.mapp(book)));
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
