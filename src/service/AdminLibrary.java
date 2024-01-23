package service;

import Controllers.MasterController;
import Database.DAO.BookDAO;
import Database.DAO.SearchDAO;
import Database.DAO.UserDAO;
import Model.Book;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class AdminLibrary {
   
    private final UserDAO userDAO;
    private final BookDAO bookDAO;
    private final SearchDAO searchDAO;
    private MasterController masterController;
    private User user;

    public AdminLibrary() {
        userDAO = new UserDAO();
        bookDAO = new BookDAO();
        searchDAO = new SearchDAO();
    }

    public void setMasterController(MasterController masterController) {
        this.masterController = masterController;
    }

   
    public void changeView(String view) {
        switch (view) {
            case "btAdd" -> System.out.println("add");
            case "btDiscard" -> {
                System.out.println("discard");
            }
            case "btImage" -> System.out.println("image");
            case "btProfile" ->{
                //from admin to profile
            }
            case "addBook" -> {
                //from admin to add book
            }
        }
    }


    public void setUser(User user) {
        this.user = user;
    }
}
