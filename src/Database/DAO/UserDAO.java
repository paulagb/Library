package Database.DAO;


import Database.ConnectionDB;
import Model.Book;
import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * THis class contains all the functions related to the user,
 * from which the database functions are called, and from which the database wil update or get info from the user.
 * <p>
 * All the functions, when calling a function to the database, stores the return as a ResultSet,
 * and then does a try/Catch to try getting the info from ResultSet and
 * storing it in a instance of the Class we are returning in each procedure
 */
public class UserDAO {
    ConnectionDB conn;

    public UserDAO() {
        conn = ConnectionDB.getInstance();
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_ID, name, surname, user_type, email, password FROM User";

        ResultSet rs = conn.selectQuery(sql);

        try {
            while (rs.next()) {
                User user = new User();
                //user.setUserId(rs.getInt("user_ID"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setUserType(rs.getString("user_type"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password")); // Ensure careful handling of passwords
                users.add(user);
            }

        } catch (SQLException throwables) {
            throwables.getSQLState();
        }
        return users;
    }

    public User checkCredentials(String username, String password) {
        String sql = "SELECT name, surname, email, user_type, password FROM User WHERE email = '" + username + "' AND password = '" + password + "'";
        ResultSet rs = conn.selectQuery(sql);
        try {
            if (rs.next()) {
                User user = new User();
                //user.setUserId(rs.getInt("user_ID"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setUserType(rs.getString("user_type"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password")); // Ensure careful handling of passwords

                System.out.println("User exists");
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean createProfile(String name, String surname, String user_type, String email, String password) {
        String sql = "INSERT INTO User (name, surname, user_type, email, password) VALUES ('" + name + "',' " + surname + "', " + "' " + user_type + "', '" + email + "', '" + password + "')";

        return conn.insertQuery(sql);
    }

    public boolean checkProfileExists(String email) {
        String sql = " SELECT * FROM User where email = '" + email + "'";
        ResultSet rs = conn.selectQuery(sql);
        try {
            return rs.next();
        } catch (SQLException throwables) {
            throwables.getSQLState();
        }
        return false;
    }
}