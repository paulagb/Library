package Controllers;

public class MasterController {

    private LoginController loginController;
    private CreateProfileController createProfileController;
    private MainPageCustomerController mainPageCustomerController;


    public MasterController(LoginController loginController, CreateProfileController createProfileController, MainPageCustomerController mainPageCustomerController) {
        this.loginController = loginController;
        this.createProfileController = createProfileController;
        this.mainPageCustomerController = mainPageCustomerController;
    }

    public void okLoginCustomer() {
        loginController.displayView(false);
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
}
