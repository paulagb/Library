package Controllers;

import UI.CreateProfile;
import UI.MainCustomer;
import com.sun.tools.javac.Main;
import service.Library;

public class MainPageCustomerController {
    private MainCustomer mainCustomerView;
    private Library logic;

    public MainPageCustomerController(MainCustomer mainCustomerView, Library logic) {
        this.mainCustomerView = mainCustomerView;
        this.logic = logic;
    }

    public void displayView(boolean b) {
        mainCustomerView.showView(b);
    }
}
