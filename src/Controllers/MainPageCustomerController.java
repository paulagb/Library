package Controllers;

import Database.DAO.BookDAO;
import Model.Book;
import service.Library;
import ui.MainCustomer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPageCustomerController implements ActionListener {
    private MainCustomer mainCustomerView;
    private Library logic;

    public MainPageCustomerController(MainCustomer mainCustomerView, Library logic) {
        this.mainCustomerView = mainCustomerView;
        this.logic = logic;
    }

    public void displayView(boolean b) {
        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> books = (ArrayList<Book>) bookDAO.getBooks();
        //System.out.println(books);
        mainCustomerView.setBooks(books);
        mainCustomerView.showView(b);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btProfile" -> logic.changeView("profile");
            case "btSearch" -> System.out.println("searching");
            case "btFavourites" -> logic.changeView("favourites");
            case "btNotification" -> logic.changeView("notification");
        }

    }
}
