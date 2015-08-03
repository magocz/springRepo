package pl.spring.demo.mock;
/**
 * @COPYRIGHT (C) 2015 Schenker AG
 *
 * All rights reserved
 */

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.internal.util.reflection.Whitebox;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.mapper.BookMaper;
import pl.spring.demo.service.impl.BookServiceImpl;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

import static org.junit.Assert.assertEquals;

/**
 * TODO The class BookServiceImplTest is supposed to be documented...
 *
 * @author AOTRZONS
 */
public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;
    @Mock
    private BookDao bookDao;
    
    private BookMaper bookMaper;

    @Before
    public void setUpt() {
        MockitoAnnotations.initMocks(this);
        bookMaper = new BookMaper();
        Whitebox.setInternalState(bookService, "bookMaper", bookMaper);
    }

    @Test
    public void testShouldSaveBook() {
        // given
        BookEntity book = new BookEntity(null, "title", "author");
        Mockito.when(bookDao.save(Mockito.any(BookEntity.class))).thenReturn(new BookEntity(1L, "title", "author"));
        // when
        BookTo result = bookService.saveBook(bookMaper.mapp(book));
        // then
        Mockito.verify(bookDao).save(Mockito.any(BookEntity.class));
        assertEquals(1L, result.getId().longValue());
    }
}
