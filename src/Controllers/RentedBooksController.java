package Controllers;

import Database.DAO.BookDAO;
import Model.Book;
import Model.User;
import service.Library;
import ui.CreateProfile;
import ui.RentedBooks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RentedBooksController implements ActionListener {
    private RentedBooks view;
    private Library logic;


    public RentedBooksController(RentedBooks rentedBooksView, Library logic) {
        this.view = rentedBooksView;
        this.logic = logic;
    }

    public void setRentedBooks(User user) {
        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> books = bookDAO.getRentedBooks(user.getEmail());
        view.setRentedBooks(books);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btFavorites" -> {
                logic.changeView("favFromProfile");
            }
            case "btSearch" -> {
                //setRentedBooks();
            }
        }

    }

    public void displayView(boolean b) {
        view.showView(b);
    }

}
