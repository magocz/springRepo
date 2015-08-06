package pl.spring.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String bookList(Map<String, Object> params) {
        final List<BookTo> allBooks = bookService.findAllBooks();
        params.remove("books");
        params.put("books", allBooks);
        return "bookList";
    }
    
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String removeBook(Map<String, Object> params, @RequestParam Long rm) {
    	String title;
    	if((title = bookService.removeBook(rm)) != null){
    		params.put("book",title ); 
    		return "removed";
    	}
    	   
        return "book not exist";
    }
}
