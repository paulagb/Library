package Database.DAO;

import Database.ConnectionDB;
import Model.Book;

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


    public ArrayList<Book> getFavouriteBooks(String userEmail) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT U.user_ID, U.name, U.surname, U.email, B.book_ID, B.state, BT.title, BT.author " +
                "FROM " +
                "Favourites F " +
                "JOIN " +
                "BookTemplate BT ON F.FK_book_template_ID = BT.book_template_ID " +
                "JOIN " +
                "Book B ON B.FK_book_template_ID = BT.book_template_ID " +
                "JOIN " +
                "User U ON F.FK_user_ID = U.user_ID" +
                " WHERE U.email = '  " + userEmail + "'";

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

    public ArrayList<Book> getRentedBooks(String userEmail) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT B.book_ID, BT.title, BT.author, R.starting_date, R.finish_date " +
                "FROM " +
                "Rent R " +
                "JOIN " +
                "Book B ON R.FK_book_ID = B.book_ID " +
                "JOIN " +
                "BookTemplate BT ON B.FK_book_template_ID = BT.book_template_ID " +
                "JOIN " +
                "User U ON R.FK_user_ID = U.user_ID " +
                "WHERE U.email = '" + userEmail + "'";


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

    public ArrayList<Book> getReservedBooks(String userEmail) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT B.book_ID as bookId, B.state,BT.description,BT.genre, BT.title, BT.author, RV.date AS reservation_date FROM " +
                "Revervation RV " +
                "JOIN " +
                "Book B ON RV.FK_book_ID = B.book_ID" +
                " JOIN " +
                "BookTemplate BT ON B.FK_book_template_ID = BT.book_template_ID " +
                "JOIN User U ON RV.FK_user_ID = U.user_ID " +
                "WHERE U.email = '" + userEmail + "'";

        ResultSet rs = conn.selectQuery(sql);

        try {
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("bookId"));
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

    public boolean rentBook(Book book) {
        // CHECK BOOK IS NOT RENTED

        //UPDATE BOOK STATUS

        return false;
    }

    public boolean addBook(Book book) {
        //TODO UPDATE QUERY
        String sql = "UPDATE ";
        return conn.updateQuery(sql);
    }


}
