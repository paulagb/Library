package Controllers;

import Model.Book;
import Model.User;
import ui.BookView;

public class MasterController {

    private LoginController loginController;
    private CreateProfileController createProfileController;
    private MainPageCustomerController mainPageCustomerController;
    private FavouriteController favouriteController;
    private RentedBooksController rentedBooksController;
    private AdminController adminController;
    private BookController bookController;


    public MasterController(LoginController loginController, CreateProfileController createProfileController, MainPageCustomerController mainPageCustomerController, FavouriteController favouriteController, RentedBooksController rentedBooksController, AdminController mainAdminController, BookController bookView) {
        this.loginController = loginController;
        this.createProfileController = createProfileController;
        this.mainPageCustomerController = mainPageCustomerController;
        this.rentedBooksController = rentedBooksController;
        this.favouriteController = favouriteController;
        this.adminController = mainAdminController;
        this.bookController = bookView;
    }

    public void okLoginCustomer(User user) {
        System.out.println("OKALOGIN");
        loginController.displayView(false);
        mainPageCustomerController.getBooks(user);
        mainPageCustomerController.displayView(true);
    }

    public void register() {
        loginController.displayView(false);
        createProfileController.displayView(true);
    }

    public void okCreateProfile() {
        createProfileController.displayView(false);
        loginController.displayView(true);
    }



    public void login() {
        createProfileController.displayView(false);
        loginController.displayView(true);
    }

    public void profile(String from, User user) {
        //TODO REFRESH MAIN PAGE, WITH BOOKS
        if (from.equals("fav")) {
            favouriteController.displayView(false);
            rentedBooksController.setRentedBooks(user);
            rentedBooksController.displayView(true);
        }

    }

    public void favBooks(String userEmail) {
        mainPageCustomerController.displayView(false);
        favouriteController.setFavBooks(userEmail);
        favouriteController.displayView(true);
    }

    public void rentedBooks(User user) {
        mainPageCustomerController.displayView(false);
        rentedBooksController.setRentedBooks(user);
        rentedBooksController.displayView(true);
    }

    public void okLoginAdmin(User user) {
        loginController.displayView(false);
        adminController.getBooks(user);
        adminController.displayView(true);
    }
    public void addBook() {
        adminController.displayAddBookview(true);
    }

    public void bookAdded() {
        //TODO REFRESH BOOKS
        adminController.displaybookAddedview(false);
        adminController.displayAddBookview(false);
        adminController.displayView(true);
    }

    public void setControllers(MainPageCustomerController mainPageCustomerController, FavouriteController favouriteController, RentedBooksController rentedBooksController, AdminController adminController) {
        this.mainPageCustomerController = mainPageCustomerController;
        this.favouriteController = favouriteController;
        this.rentedBooksController = rentedBooksController;
        this.adminController = adminController;
    }

    public void adminUsers() {
        adminController.displayView(false);
        adminController.displayUsersView(true);
    }

    public void discardAddBook() {
        adminController.displayAddBookview(false);
        adminController.displayView(true);
    }

    public void favourites(User user) {
        rentedBooksController.displayView(false);
        favouriteController.setFavBooks(user.getEmail());
        favouriteController.displayView(true);
    }

    public void showBook(Book book) {
              bookController.showBook(book);
    }
}
