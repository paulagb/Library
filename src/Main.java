import Controllers.*;
import ui.*;
import service.Library;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Library logic = new Library();

                //LOGIN CUSTOMER
                Login loginView = new Login();
                LoginController loginController = new LoginController(loginView, logic);
                loginView.setControllers(loginController);

                //CREATE PROFILE
                CreateProfile createProfileView = new CreateProfile();
                CreateProfileController createProfileController = new CreateProfileController(createProfileView, logic);
                createProfileView.setControllers(createProfileController);

                // MAIN CUSTOMER
                MainCustomer mainCustomerView = new MainCustomer();
                MainPageCustomerController mainPageCustomerController = new MainPageCustomerController(mainCustomerView, logic);
                mainCustomerView.setControllers(mainPageCustomerController);

                //FAVOURITE BOOKS
                Favourites favouritesView = new Favourites();
                FavouriteController favouriteController = new FavouriteController(favouritesView,logic);
                favouritesView.setControllers(favouriteController);

                //RENTED BOOKS
                RentedBooks rentedBooksView = new RentedBooks();
                RentedBookController rentedBookController = new RentedBookController(rentedBooksView,logic);
                rentedBooksView.setControllers(rentedBookController);

                //TODO RESERVED BOOKS VIEW


                MasterController masterController = new MasterController(loginController, createProfileController, mainPageCustomerController, favouriteController,rentedBookController);
                logic.setMasterController(masterController);


                loginView.setVisible(true);
                //mainPageCustomerController.showBooks();

               // logic.listRentedBooks("john@example.com");



            }
        });

    }
}
