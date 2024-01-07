package service;

import Controllers.MasterController;
import Database.DAO.UserDAO;
import Model.User;

public class Library {
    private UserDAO userDAO;
    private MasterController masterController;
    private User user;

    public Library() {
        userDAO = new UserDAO();
    }

    public void setMasterController(MasterController masterController) {
        this.masterController = masterController;
    }

    public boolean checkCredentials(String username, String password) {
        user = userDAO.checkCredentials(username, password);
        return user != null;
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

        }
    }

    public boolean checkIfProfileExists(String email) {
        return false;
    }

    public boolean createProfile(String username, String email, String password) {
        return userDAO.createProfile(username, "surname", "user", email, password);
    }
}

