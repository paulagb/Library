package Controllers;

import Database.DAO.BookDAO;
import Model.Book;
import UI.CreateProfile;
import UI.MainCustomer;
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
        mainCustomerView.showView(b);
    }

    public void showBooks(){
        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> books = (ArrayList<Book>) bookDAO.getBooks();
        System.out.println(books);
    }
}
