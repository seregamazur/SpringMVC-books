package spring.service;

import spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImp implements BookService {

    private  BookRepository repository;

    @Autowired
    public BookServiceImp(BookRepository repository) {
        super();
        this.repository = repository;
    }
    BookServiceImp(){}

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
