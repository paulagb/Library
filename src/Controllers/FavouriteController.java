package Controllers;

import Database.DAO.BookDAO;
import Model.Book;
import service.Library;
import ui.Favourites;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FavouriteController implements ActionListener {
    private Favourites favView;
    private Library logic;


    public FavouriteController(Favourites favoureitesView, Library logic) {
        this.favView = favoureitesView;
        this.logic = logic;
    }


    public void setFavBooks(String userEmail) {
        BookDAO bookDAO = new BookDAO();
        //ArrayList<Book> favBooks = bookDAO.getFavouriteBooks(userEmail);
        ArrayList<Book> books = bookDAO.getReservedBooks(userEmail);
        favView.setFavBooks(books);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void displayView(boolean visible) {
        favView.setVisible(visible);
    }
}
