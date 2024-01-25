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
import java.sql.Timestamp;
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
                Book book = getBooksInfo(rs);
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
        String sql = "SELECT BT.*, B.* " +
                "FROM " +
                "Favourites F " +
                "JOIN " +
                "BookTemplate BT ON F.FK_book_template_ID = BT.book_template_ID " +
                "JOIN " +
                "Book B ON B.FK_book_template_ID = BT.book_template_ID " +
                "JOIN " +
                "User U ON F.FK_user_ID = U.user_ID " +
                "WHERE U.email = '" + userEmail + "'";
        System.out.println(sql);
        ResultSet rs = conn.selectQuery(sql);

        try {
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_ID"));
                book.setAuthor(rs.getString("author"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setFavourite(true);
                book.setRented(false);
                book.setReserved(false);
                book.setImagePath(rs.getString("path"));
                book.setGenre(rs.getString("genre"));
                book.setImageIcon(readPhoto(rs.getString("path")));
                book.setBook_template_id(rs.getInt("FK_book_template_ID"));

                switch (rs.getString("state")) {
                    case "rented" -> book.setRented(true);
                    case "reserved" -> book.setReserved(true);
                }
                books.add(book);
            }

        } catch (SQLException throwables) {
            System.out.println("Error getting the favourite books " + throwables.getSQLState());
        }
        return books;
    }

    private Book getBooksInfo(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_ID"));
        book.setAuthor(rs.getString("author"));
        book.setTitle(rs.getString("title"));
        book.setDescription(rs.getString("description"));
        book.setFavourite(false);
        book.setRented(false);
        book.setReserved(false);
        book.setImagePath(rs.getString("path"));
        book.setGenre(rs.getString("genre"));
        book.setImageIcon(readPhoto(rs.getString("path")));
        book.setBook_template_id(rs.getInt("FK_book_template_ID"));

        switch (rs.getString("state")) {
            case "rented" -> book.setRented(true);
            case "reserved" -> book.setReserved(true);
        }
        return book;
    }

    public ArrayList<Book> getRentedBooks(String userEmail) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT B.*, BT.* " +
                "FROM " +
                "Rent R " +
                "JOIN " +
                "Book B ON R.FK_book_ID = B.book_ID " +
                "JOIN " +
                "BookTemplate BT ON B.FK_book_template_ID = BT.book_template_ID " +
                "JOIN " +
                "User U ON R.FK_user_ID = U.user_ID " +
                "WHERE U.email = '" + userEmail + "'";
        System.out.println(sql);
        ResultSet rs = conn.selectQuery(sql);

        try {
            while (rs.next()) {
                Book book = getBooksInfo(rs);
                books.add(book);
            }

        } catch (SQLException throwables) {
            System.out.println( "Error getting the rented books " + throwables.getSQLState());
        }
        return books;
    }

    public ArrayList<Book> getReservedBooks(String userEmail) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT B.* , BT.* ,  RV.date AS reservation_date FROM " +
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
                Book book = getBooksInfo(rs);
                books.add(book);
            }

        } catch (SQLException throwables) {
            System.out.println("Error getting the reserved books " + throwables.getSQLState());
        }
        return books;
    }

    public boolean rentBook(Book book, int userId) {
        // CHECK BOOK IS NOT RENTED
        String sqlUpdateBook = "UPDATE Book " +
                "SET state = 'rented' " +
                "WHERE " +
                "FK_book_template_ID = (SELECT book_template_ID FROM BookTemplate WHERE title = '" + book.getTitle() +
                "' AND author = '" + book.getAuthor() + "')" +
                "AND book_ID = " + book.getBookId() + ";";
        System.out.println(sqlUpdateBook);
        conn.updateQuery(sqlUpdateBook);


        String insertToREnt = "INSERT INTO Rental (FK_user_ID, FK_book_ID, starting_date, finish_date)" +
                "VALUES (" + userId + ", " + book.getBookId() + ", '2023-01-24', '2023-01-30');";
        System.out.println(insertToREnt);
        conn.insertQuery(insertToREnt);
        //UPDATE BOOK STATUS

        return false;
    }

    public boolean reserveBook(Book book) {

        return false;
    }

    public boolean addFavBook(Book book, User user) {
        String sql = "INSERT INTO Favourites (FK_book_template_ID, FK_user_id)" +
                "VALUES (" + book.getBookId() + ", " + user.getUserID() + ")" +
                "ON DUPLICATE KEY UPDATE FK_book_template_ID = " + book.getBook_template_id() + ", FK_user_id = " + user.getUserID() + ";";
        System.out.println(sql);
        return conn.insertQuery(sql);
    }

    public boolean removeFavBook(Book book, User user) {
        String sql = "DELETE FROM Favourites " +
                "WHERE FK_book_template_ID = " + book.getBook_template_id() +
                " AND FK_user_id = " + user.getUserID() + ";";
        System.out.println(sql);
        return conn.deleteQuery(sql);
    }

    public boolean updateBookStatus(Book book, String status, User user) {
        String sql = "DELETE FROM Favourites" +
                "WHERE FK_book_template_ID = '" + book.getBookId()
                + "' AND FK_user_id = '" + user.getUserID() + "';";
        return false;
    }


    public boolean addBook(Book book) {

        String insertBookTemplateSQL = "INSERT INTO BookTemplate (title, author, description, genre, path) VALUES ( "
                + "'" + book.getTitle() + "','" + book.getAuthor() + "','" + book.getDescription() + "','" + book.getGenre() + "','BookPhotos/default.jpg')";

        System.out.println(insertBookTemplateSQL);
        try {
            conn.insertQuery(insertBookTemplateSQL);

            String getBookTemplateIdSQL = "SELECT book_template_ID FROM BookTemplate WHERE title = '"
                    + book.getTitle() + "' AND author = '" + book.getAuthor() + "';";
            System.out.println(getBookTemplateIdSQL);
            ResultSet rs = conn.selectQuery(getBookTemplateIdSQL);

            if (rs.next()) {
                int bookTemplateId = rs.getInt("book_template_ID");

                String insertBookSQL = "INSERT INTO Book (FK_book_template_ID, state) VALUES ( " + bookTemplateId + ", 'available');";
                System.out.println(insertBookSQL);
                conn.insertQuery(insertBookSQL);

                return true;
            } else {
                System.out.println("No result found for BookTemplate ID");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error inserting book template " + e.getMessage());
            return false;
        }
    }

    public ImageIcon readPhoto(String path) {
        BufferedImage profileImageBuf = null;
        if (path != null) {
            try {
                profileImageBuf = ImageIO.read(new File(path));
                ImageIcon profileImage = new ImageIcon(profileImageBuf);
                return profileImage;
            } catch (IOException e) {
                System.out.println("No image was found\n");
                return null;
            }
        } else {
            System.out.println("No image was found\n");
            return null;
        }
    }
}
