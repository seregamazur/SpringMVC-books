package spring.dao;

import spring.entity.Book;

import java.util.List;

public interface BookDAO {

    Book getBookById(Long id);

    List<Book> getAllBooks();

    boolean saveBook(Book book);

    boolean deleteBook(Long id);

}
