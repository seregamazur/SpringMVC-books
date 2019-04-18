package service;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImp(BookRepository repository) {
        this.repository = repository;
    }

    public Book getBookById(Long id) {
        return repository.findById(id).get();
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        repository.findAll().forEach(books::add);
        return books;
    }

    public boolean saveBook(Book book) {
        try {
            repository.save(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteBook(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
