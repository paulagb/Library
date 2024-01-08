import Controllers.CreateProfileController;
import Controllers.LoginController;
import Controllers.MainPageCustomerController;
import Controllers.MasterController;
import ui.CreateProfile;
import ui.Login;
import ui.MainCustomer;
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

                MainCustomer mainCustomerView = new MainCustomer();
                MainPageCustomerController mainPageCustomerController = new MainPageCustomerController(mainCustomerView, logic);
                mainCustomerView.setControllers(mainPageCustomerController);

                MasterController masterController = new MasterController(loginController, createProfileController, mainPageCustomerController);
                logic.setMasterController(masterController);


                loginView.setVisible(true);
                //mainPageCustomerController.showBooks();


            }
        });

    }
}
