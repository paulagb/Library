import Database.ConnectionDB;
import Model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();
        connectionDB.connect();
        List<User> users = connectionDB.getUsers();
        for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        }
     /*  Logic  logic = new Logic();
        logic.getAllUsers();
*/

    }
}
