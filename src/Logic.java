import Database.DAO.UserDAO;
import Model.User;

import java.util.List;

public class Logic {


    public void getAllUsers() {
        UserDAO userDAO = new UserDAO();

        List<User> users = userDAO.getUsers();
        for (User user : users) {
            System.out.println(user.getEmail() + " " + user.getPassword());
        }
    }
}
