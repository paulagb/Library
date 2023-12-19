package Database.DAO;


import Database.ConnectionDB;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public UserDAO(){
        conn = ConnectionDB.getInstance();
    }

    public boolean getUsers(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_ID, name, surname, user_type, email, password FROM User";

        ResultSet result = conn.selectQuery(sql);
        boolean success = false;
        try{
            while(result.next()){
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

}