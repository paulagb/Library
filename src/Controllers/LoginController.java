package Controllers;

import service.Library;
import ui.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private Login loginView;
    private Library logic;

    public LoginController(Login loginView, Library logic) {
        this.loginView = loginView;
        this.logic = logic;
        //loginView.showView(true);
    }

    private void checkCredentials() {

        String username = loginView.getUsername();
        String password = loginView.getPassword();

        if (username.isBlank() || password.isBlank()) {
            loginView.showMessage("Email or password is blank");
        } else if (logic.checkCredentials(username, password)) {
            logic.changeView("mainPage");
        } else {
            loginView.showMessage("Email or password does not exists");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("btLogin")) {
            checkCredentials();
        } else if (e.getActionCommand().equals("register")) {
            logic.changeView("register");
        }

    }

    public void displayView(boolean b) {
        loginView.showView(b);
    }
}