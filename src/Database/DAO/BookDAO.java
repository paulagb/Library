package Database.DAO;

import Database.ConnectionDB;
import Model.Book;
import Model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    ConnectionDB conn;

    public BookDAO() {
        conn = ConnectionDB.getInstance();
    }

    public List<Book> getBooks(int user_id) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT BookTemplate.*, Book.*, Favourites.FK_user_id AS user_id, " +
                "CASE WHEN Favourites.FK_user_id IS NOT NULL THEN 1 ELSE 0 END AS is_favorite " +
                "FROM BookTemplate " +
                "JOIN Book ON BookTemplate.book_template_ID = Book.FK_book_template_ID " +
                "LEFT JOIN Favourites ON Favourites.FK_book_template_ID = BookTemplate.book_template_ID " +
                "AND Favourites.FK_user_id = " + user_id + " ";

        ResultSet rs = conn.selectQuery(sql);

        try {
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_ID"));
                book.setAuthor(rs.getString("author"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setGenre(rs.getString("genre"));
                book.setFavourite(rs.getBoolean("is_favorite"));
                book.setRented(false);
                book.setReserved(false);
                book.setImageIcon(readPhoto(rs.getString("path")));
                book.setImagePath(rs.getString("path"));
                switch (rs.getString("state")) {
                    case "rented" -> book.setRented(true);
                    case "reserved" -> book.setRented(false);
                }
                System.out.println(book);
                books.add(book);
            }

        } catch (SQLException throwables) {
            System.out.println("Error getting the books " + throwables.getSQLState());
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

    public boolean reserveBook(Book book) {

        return false;
    }

    public boolean addFavBook(Book book, User user) {
        String sql = "INSERT INTO Favourites (FK_book_template_ID, FK_user_id)" +
                "VALUES ('" + book.getBookId() + "', '" + user.getUserID() + "')" +
                "ON DUPLICATE KEY UPDATE FK_book_template_ID = '" + book.getBookId() + "', FK_user_id = '" + user.getUserID() + "';";
        return conn.insertQuery(sql);
    }

    public boolean removeFavBook(Book book, User user) {
        String sql = "DELETE FROM Favourites" +
                "WHERE FK_book_template_ID = '" + book.getBookId() +
                "' AND FK_user_id = '" + user.getUserID() + "';";
        return conn.deleteQuery(sql);
    }

    public boolean updateBookStatus(Book book, String status, User user) {
        String sql = "DELETE FROM Favourites" +
                "WHERE FK_book_template_ID = '" + book.getBookId()
                + "' AND FK_user_id = '" + user.getUserID() + "';";
        return false;
    }

    public boolean addBook(Book book) {
        //TODO UPDATE QUERY
        String sql = "UPDATE ";
        return conn.updateQuery(sql);
    }

    public ImageIcon readPhoto (String path){
       BufferedImage profileImageBuf = null;
       path = "BookPhotos/1984.jpg";
        if(path != null) {
            try {
                profileImageBuf = ImageIO.read(new File(path));
                ImageIcon profileImage = new ImageIcon(profileImageBuf);
                return profileImage;
            } catch (IOException e) {
                System.out.println("No image was found\n");
                return null;
            }
        }
        else{
            System.out.println("No image was found\n");
            return null;
        }
    }
}
