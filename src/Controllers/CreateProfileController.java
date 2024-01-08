package Controllers;

import ui.CreateProfile;
import service.Library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProfileController implements ActionListener {
    private CreateProfile createProfileView;
    private Library logic;


    public CreateProfileController(CreateProfile createProfileView, Library logic) {
        this.createProfileView = createProfileView;
        this.logic = logic;
    }

    public void displayView(boolean b) {
        createProfileView.showView(b);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            String username = createProfileView.getUsername();
            String password = createProfileView.getPassword();
            String password1 = createProfileView.getPassword1();
            String email = createProfileView.getEmail();

            if (email.isBlank() || password.isBlank() || password.isBlank()) {
                createProfileView.showMessage("Some field is blank");
            } else if (!password.equals(password1)) {
                createProfileView.showMessage("Passwords do not match");
            } else if (!logic.checkIfProfileExists(email)) {
                if (logic.createProfile(username, email, password)) {
                    createProfileView.showMessage("Profile created");
                    logic.changeView("login");
                } else {
                    createProfileView.showMessage("Profile not created");
                }
            }
        }else if (e.getActionCommand().equals("Login")) {
            logic.changeView("login");
        }
    }
}
