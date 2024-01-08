package Controllers;

import Database.DAO.BookDAO;
import Model.Book;
import ui.CreateProfile;
import ui.MainCustomer;
import com.sun.tools.javac.Main;
import service.Library;

import java.util.ArrayList;

public class MainPageCustomerController {
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
}
