package Controllers;

import Database.DAO.BookDAO;
import Model.Book;
import service.Library;
import ui.CreateProfile;
import ui.RentedBooks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RentedBookController implements ActionListener {
    private RentedBooks view;
    private Library logic;


    public RentedBookController(RentedBooks rentedBooksView, Library logic) {
        this.view = rentedBooksView;
        this.logic = logic;
    }

    public void setRentedBooks(String userEmail) {
        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> books = bookDAO.getRentedBooks(userEmail);
        view.setRentedBooks(books);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void displayView(boolean b) {
        view.showView(b);
    }

}
