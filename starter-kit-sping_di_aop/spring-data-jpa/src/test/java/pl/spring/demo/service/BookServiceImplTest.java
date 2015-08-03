package pl.spring.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.BookTo;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testShouldFindAllBooks() {
        // when
        List<BookTo> allBooks = bookService.findAllBooks();
        // then
        assertNotNull(allBooks);
        assertFalse(allBooks.isEmpty());
        assertEquals(7, allBooks.size());
    }

    @Test
    public void testShouldFindAllBooksByTitle() {
        // given
        final String title = "Opium w rosole";
        // when
        List<BookTo> booksByTitle = bookService.findBooksByTitle(title);
        // then
        assertNotNull(booksByTitle);
        assertFalse(booksByTitle.isEmpty());
    }
    
    @Test
    public void testShouldFindAllBooksByTitle2() {
        // given
        final String title = "rOm";
        // when
        List<BookTo> booksByTitle = bookService.findBooksByTitle(title);
        // then
        assertNotNull(booksByTitle);
        assertFalse(booksByTitle.isEmpty());
        assertEquals(2, booksByTitle.size());
    }
    
    @Test
    public void testShouldFindAllBooksByAuthor() {
        // given
        final String author = "Wiliam";
        // when
        List<BookTo> booksByAuthor = bookService.findBooksByAuthor(author);
        // then
        assertNotNull(booksByAuthor);
        assertFalse(booksByAuthor.isEmpty());
        assertEquals(2, booksByAuthor.size());
    }
    
    @Test
    public void testShouldFindAllBooksByAuthor2() {
        // given
        final String author = "n";
        // when
        List<BookTo> booksByAuthor = bookService.findBooksByAuthor(author);
        // then
        assertNotNull(booksByAuthor);
        assertFalse(booksByAuthor.isEmpty());
        assertEquals(2, booksByAuthor.size());
    }

    @Test(expected = BookNotNullIdException.class)
    public void testShouldThrowBookNotNullIdException() {
        // given
        final BookTo bookToSave = new BookTo();
        bookToSave.setId(22L);
        // when
        bookService.saveBook(bookToSave);
        // then
        fail("test should throw BookNotNullIdException");
    }
}
