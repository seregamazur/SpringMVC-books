package spring.mapper;

import org.springframework.jdbc.core.RowMapper;
import spring.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setPrice(resultSet.getInt("price"));
        return book;
    }
}
