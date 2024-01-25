package service;

import Controllers.BookController;
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
    private final BookDAO bookDAO;
    private final SearchDAO searchDAO;
    private User user;
    private MasterController masterController;

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
            case "profile":
                masterController.profile("main", user);
                break;
            case "mainPage":
                if (user.getUserType().equals("user")) {
                    masterController.okLoginCustomer(user);
                } else {
                    masterController.okLoginAdmin(user);

                }
                break;
            case "mainFromFav":
                masterController.mainFromFav();
                break;
            case "login":
                masterController.login();
                break;
            case "profileFromFav":
                masterController.profile("fav", user);
                break;
            case "favFromProfile":
                masterController.favourites(user);
                break;
            case "favourites":
                masterController.favBooks(user.getEmail());
                break;
            case "addBook":
                masterController.addBook();
                break;
            case "bookAdded":
                masterController.bookAdded();
                break;
            case "adminUsers":
                masterController.adminUsers();
                break;
            case "discardAddBook":
                masterController.discardAddBook();
                break;
            case "searchFromProfile":
                //masterController.searchFromProfile(user);
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

    public List<Book> listFavouriteBooks(String userEmail) {
        return bookDAO.getFavouriteBooks(userEmail);
    }

    public List<Book> listRentedBooks(String userEmail) {
        return bookDAO.getRentedBooks(userEmail);
    }

    public List<Book> listReservedBooks(String userEmail) {
        return bookDAO.getReservedBooks(userEmail);
    }


    public boolean addBook(Book book) {
        book.setReserved(false);
        book.setRented(false);
        book.setFavourite(false);
        return bookDAO.addBook(book);
    }

    //TODO
    public boolean rentBook(Book book) {
        return bookDAO.rentBook(book, user.getUserID());
    }

    public ArrayList<Book> search(String search) {
        return searchDAO.searchByAuthorOrTitle(user, search);
    }

    //TODO DELETE, THIS IS JUST FOR TEST
    public void setUSer(User user) {
        this.user = user;
    }

    public void showBook(Book book) {
        masterController.showBook(book);
    }

    public BookController getBookController() {
        return masterController.getBookController();
    }

    public void unFavBook(Book book) {
        bookDAO.removeFavBook(book, user);
    }

    public void favBook(Book book) {
        bookDAO.addFavBook(book, user);
    }
}

