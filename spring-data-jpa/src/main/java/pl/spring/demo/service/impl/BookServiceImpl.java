package pl.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookTo> findAllBooks() {
        return BookMapper.map2To(bookRepository.findAll());
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {
        return BookMapper.map2To(bookRepository.findBookByTitle(title));
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
        return BookMapper.map2To(bookRepository.findBookByAuthor(author));
    }
    
    @Override
    @Transactional
	public String removeBook(Long id) {
    	if(bookRepository.exists(id)){
    		String title = bookRepository.getOne(id).getTitle();		
        	bookRepository.delete(id);
        	System.out.println(title + " " + id.longValue()); 
        	return title;
    	}    	
    	return null;
	}
    
    

    @Override
    @Transactional(readOnly = false)
    public BookTo saveBook(BookTo book) {
        BookEntity entity = BookMapper.map(book);
        entity = bookRepository.save(entity);
        return BookMapper.map(entity);
    }

	@Override
	@Transactional
	public String removeBook(BookTo book) {
		if(bookRepository.exists(book.getId())){
			bookRepository.delete(BookMapper.map(book));
			return book.getTitle();
		}
		
		return null;
	}

	@Override
	@Transactional
	public void updateBook(BookTo book) {
		bookRepository.updateBook(book.getId(), book.getAuthors(), book.getTitle());
	}

	@Override
	public boolean exist(Long id) {
		return bookRepository.exists(id);	
	}
	
}
