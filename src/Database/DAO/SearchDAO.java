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

public class SearchDAO {
    private ConnectionDB conn;

    public SearchDAO() {
        conn = ConnectionDB.getInstance();
    }

    public ArrayList<Book> searchByAuthorOrTitle(User user, String search) {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT BookTemplate.*, Book.*, Favourites.FK_user_id AS user_id," +
                " CASE WHEN Favourites.FK_user_id IS NOT NULL THEN 1 ELSE 0 END as is_favourite " +
                "FROM BookTemplate " +
                "JOIN Book ON BookTemplate.book_template_ID = Book.FK_book_template_ID " +
                "LEFT JOIN Favourites ON Favourites.FK_book_template_ID = BookTemplate.book_template_ID " +
                "AND Favourites.FK_user_id = " + user.getUserID() +
                " WHERE BookTemplate.title LIKE '%" + search + "%' " +
                "OR BookTemplate.author LIKE '%" + search + "%';";
        System.out.println(sql);

        ResultSet rs = conn.selectQuery(sql);

        try {
            while (rs.next()) {
                Book book = getBooksInfo(rs);
                books.add(book);
            }

        } catch (SQLException throwables) {
            System.out.println(throwables.getSQLState());
        }

        return books;
    }
    private Book getBooksInfo(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_ID"));
        book.setAuthor(rs.getString("author"));
        book.setTitle(rs.getString("title"));
        book.setDescription(rs.getString("description"));
        book.setGenre(rs.getString("genre"));
        book.setFavourite(true);
        book.setRented(false);
        book.setReserved(false);
        book.setImageIcon(readPhoto(rs.getString("path")));
        book.setImagePath(rs.getString("path"));
        switch (rs.getString("state")) {
            case "rented" -> book.setRented(true);
            case "reserved" -> book.setReserved(true);
        }
        return book;
    }
    public ImageIcon readPhoto(String path) {
        BufferedImage profileImageBuf = null;
        path = "BookPhotos/1984.jpg";
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
