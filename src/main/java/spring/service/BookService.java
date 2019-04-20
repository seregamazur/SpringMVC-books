package spring.service;

import spring.model.Book;

import java.util.List;

public interface BookService {

    Book getBookById(Long id);

    List<Book> getAllBooks();

    boolean saveBook(Book book);

    boolean deleteBook(Long id);

}
