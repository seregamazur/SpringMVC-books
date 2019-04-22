package spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import spring.entity.Book;
import spring.mapper.BookMapper;

import javax.sql.DataSource;
import java.util.List;

public class BookDAOImp implements BookDAO {

    private JdbcTemplate template;

    public BookDAOImp(DataSource source) {
        template = new JdbcTemplate(source);
    }

    @Override
    public Book getBookById(Long id) {
        String SQL = "select * from Book where id = ?";
        Book book = (Book) template.queryForObject(SQL, new Object[]{id}, new BookMapper());
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) template.query("select * from Book", new BookMapper());
    }

    @Override
    public boolean saveBook(Book book) {
        String SQL = "insert into Book(name,author,price) values (?,?,?)";
        try {
            template.update(SQL, book.getName(), book.getAuthor(), book.getPrice());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteBook(Long id) {
        String SQL = "delete from Book where id = ?";
        try {
            template.update(SQL, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
