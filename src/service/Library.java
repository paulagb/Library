package service;

import Controllers.MasterController;
import Database.DAO.BookDAO;
import Database.DAO.UserDAO;
import Model.Book;
import Model.User;

import java.util.List;

public class Library {
    private UserDAO userDAO;
    private MasterController masterController;
    private User user;
    private BookDAO bookDAO;

    public Library() {
        userDAO = new UserDAO();
        bookDAO = new BookDAO();
    }

    public void setMasterController(MasterController masterController) {
        this.masterController = masterController;
    }

    public void changeView(String view) {
        switch (view) {
            case "register":
                masterController.register();
                break;
            case "mainPage":
                if (user.getUserType().equals("user")) {
                    masterController.okLoginCustomer();
                } else {
                    masterController.okLoginAdmin();
                }
                masterController.okLoginCustomer();
                break;
            case "login":
                masterController.login();
                break;
            case "profile":
                masterController.profile();
                break;
            case "favourites":
                masterController.favBooks(user.getEmail());
                break;
            case "notification":
                masterController.notification();
                break;


        }
    }

    public boolean checkCredentials(String username, String password) {
        user = userDAO.checkCredentials(username, password);
        return user != null;
    }

    public boolean checkIfProfileExists(String email) {
        return userDAO.checkProfileExists(email);
    }

    public boolean createProfile(String username, String email, String password) {
        return userDAO.createProfile(username, "surname", "user", email, password);
    }

    public List<Book> listFavouriteBooks (String userEmail){
        return bookDAO.getFavouriteBooks(userEmail);
    }
    public List<Book> listRentedBooks (String userEmail){
        return bookDAO.getRentedBooks(userEmail);
    }
    public List<Book> listReservedBooks  (String userEmail){
        return bookDAO.getReservedBooks(userEmail);
    }



    public boolean addBook(Book book){
        return bookDAO.addBook(book);
    }

    //TODO
    public boolean rentBook (Book book){
        return bookDAO.rentBook(book);
    }

}

