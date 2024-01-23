package Controllers;

import Database.DAO.BookDAO;
import Model.Book;
import Model.User;
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

    public void getBooks(User user) {
        ArrayList<Book> books = new ArrayList<>();
        BookDAO bookDAO = new BookDAO();
        books = (ArrayList<Book>) bookDAO.getBooks(user.getUserID());

        mainCustomerView.setBooks(books);
    }


    public void displayView(boolean b) {
        mainCustomerView.showView(b);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btProfile" -> logic.changeView("profile");
            case "btSearch" -> {
                System.out.println("searching");
                mainCustomerView.setBooks(logic.search(mainCustomerView.getSearch()));
                mainCustomerView.refresh();
                //TODO REFRESH MAIN CUSTOMER VIEW, PARA QUE SALGA LA SEARCH

            }
            case "btFavourites" -> logic.changeView("favourites");
        }

    }
}
