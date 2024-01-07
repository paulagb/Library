package Database.DAO;

import Database.ConnectionDB;
import Model.Book;
import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    ConnectionDB conn;

    public BookDAO() {
        conn = ConnectionDB.getInstance();
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM BookTemplate, Book WHERE book_template_ID = book_ID";

        ResultSet rs = conn.selectQuery(sql);

        try {
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_ID"));
                book.setAuthor(rs.getString("author"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setGenre(rs.getString("genre"));
                books.add(book);
            }

        } catch (SQLException throwables) {
            throwables.getSQLState();
        }
        return books;
    }


}
