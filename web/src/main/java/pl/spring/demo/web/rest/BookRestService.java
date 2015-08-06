package pl.spring.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.List;

@Controller
@ResponseBody
public class BookRestService {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
	public List<BookTo> findBooksByTitle(@RequestParam("titlePrefix") String titlePrefix) {
		return bookService.findBooksByTitle(titlePrefix);
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public BookTo saveBook(@RequestBody BookTo book) {
		return bookService.saveBook(book);
	}

	@RequestMapping(value = "/book", method = RequestMethod.DELETE)
	public String removeBook(@RequestBody BookTo book) {
		bookService.removeBook(book);
		return "removed";
	}
	
	@RequestMapping(value = "/book-delete/{id}", method = RequestMethod.DELETE)
	public String removeBook1(@PathVariable("id")Long id) {
		if(bookService.removeBook(id) != null){
			return "removed";
		}
		return "book not exist";
	}

	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public BookTo updateBook(@RequestBody BookTo book) {
		if(bookService.exist(book.getId())){
				bookService.saveBook(book);
				return book;
		}
		return null;
	}
}
