import Controllers.*;
import Database.DAO.UserDAO;
import Model.Book;
import Model.User;
import service.Library;
import ui.*;

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
                Favourites favouritesView = new Favourites(logic);
                FavouriteController favouriteController = new FavouriteController(favouritesView, logic);
                favouritesView.setControllers(favouriteController);

                //RENTED BOOKS
                RentedBooks rentedBooksView = new RentedBooks();
                RentedBooksController rentedBooksController = new RentedBooksController(rentedBooksView, logic);
                rentedBooksView.setControllers(rentedBooksController);


                //-------------------   ADMIN   -------------------//
                MainAdmin mainAdminView = new MainAdmin();
                AdminController mainAdminController = new AdminController(mainAdminView, logic);
                mainAdminView.setControllers(mainAdminController);

                AddBook addBookView = new AddBook();
                mainAdminController.setAddBookView(addBookView);
                addBookView.setControllers(mainAdminController);

                BookAdded bookAddedView = new BookAdded();
                mainAdminController.setBookAddedView(bookAddedView);
                bookAddedView.setControllers(mainAdminController);

                Users usersView = new Users();
                mainAdminController.setUsersView(usersView);
                usersView.setControllers(mainAdminController);

                MasterController masterController = new MasterController(loginController, createProfileController, mainPageCustomerController, favouriteController, rentedBooksController, mainAdminController);
                logic.setMasterController(masterController);
                mainCustomerView.setLibrary(logic);
                loginView.setVisible(true);

                //TODO DELETE, THIS IS JUST FOR TEST
                UserDAO userDAO = new UserDAO();
                // admin-> jane@example.com, password2
                // customer-> john@example, password1
                /*User user = userDAO.checkCredentials("john@example.com", "password1");
                System.out.println(user.getUserID());
                logic.setUSer(user);
                Book book = new Book();
                book.setBookID(3);
                book.setBookName("1984");
                book.setAuthor("George Orwell");*/

                //logic.rentBook(book);
                logic.changeView("mainPage");

                // logic.listRentedBooks("john@example.com");


            }
        });

    }
}
