package service;

import Controllers.MasterController;
import Database.DAO.BookDAO;
import Database.DAO.SearchDAO;
import Database.DAO.UserDAO;
import Model.Book;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final UserDAO userDAO;
    private MasterController masterController;
    private User user;
    private final BookDAO bookDAO;
    private final SearchDAO searchDAO;

    public Library() {
        userDAO = new UserDAO();
        bookDAO = new BookDAO();
        searchDAO = new SearchDAO();
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
                    masterController.okLoginCustomer(user);
                } else {
                    masterController.okLoginAdmin();
                }
                break;
            case "login":
                masterController.login();
                break;
            case "profileFromFav":
                masterController.profile("fav");
                break;
            case "favourites":
                masterController.favBooks(user.getEmail());
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

    public ArrayList<Book> search(String search) {
        return searchDAO.searchByAuthorOrTitle(user, search);
    }

    //TODO DELETE, THIS IS JUST FOR TEST
    public void setUSer(User user) {
        this.user = user;
    }
}

