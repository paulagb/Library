package Controllers;

import Model.User;

public class MasterController {

    private LoginController loginController;
    private CreateProfileController createProfileController;
    private MainPageCustomerController mainPageCustomerController;
    private FavouriteController favouriteController;
    private RentedBookController rentedBookController;


    public MasterController(LoginController loginController, CreateProfileController createProfileController, MainPageCustomerController mainPageCustomerController, FavouriteController favouriteController, RentedBookController rentedBookController) {
        this.loginController = loginController;
        this.createProfileController = createProfileController;
        this.mainPageCustomerController = mainPageCustomerController;
        this.rentedBookController = rentedBookController;
        this.favouriteController = favouriteController;
    }

    public void okLoginCustomer(User user) {
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

    public void okLoginAdmin() {
        // main page admin
    }

    public void login() {
        createProfileController.displayView(false);
        loginController.displayView(true);
    }

    public void profile() {
        //TODO REFRESH MAIN PAGE, WITH BOOKS
        mainPageCustomerController.displayView(true);
    }

    public void favBooks(String userEmail) {
        mainPageCustomerController.displayView(false);
        favouriteController.setFavBooks(userEmail);
        favouriteController.displayView(true);
    }

    public void rentedBooks(String userEmail) {
        mainPageCustomerController.displayView(false);
        rentedBookController.setRentedBooks(userEmail);
        rentedBookController.displayView(true);
    }

    public void notification() {
        mainPageCustomerController.displayView(false);
        //TODO SET NOTIFICATION VIEW VISIBLE
    }
}
