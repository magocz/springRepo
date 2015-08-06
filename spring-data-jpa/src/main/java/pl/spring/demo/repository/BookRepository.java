package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.BookTo;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

	@Query("select book from BookEntity book where upper(book.title) like concat(upper(:title), '%')")
	public List<BookEntity> findBookByTitle(@Param("title") String title);

	@Query("select book from BookEntity book where upper(book.authors) like concat('%', upper(:author), '%')")
	public List<BookEntity> findBookByAuthor(@Param("author") String author);
	
	@Modifying
	@Query("UPDATE BookEntity SET title =:title, author = :author WHERE id = :id")
	public void updateBook(@Param("id")Long id, @Param("author") String author, @Param("title") String title);

}
