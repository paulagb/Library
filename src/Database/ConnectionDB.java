package Database;

import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to connect to the Database, and to work directly with it
 */
public class ConnectionDB {
    private static String userName;
    private static String password;
    private static String db;
    private static int port;
    private static String url = "jdbc:mysql://";
    private static String ipAdress;
    private static Connection conn;
    private static Statement s;
    private static ConnectionDB instance;

    /**
     * Constructor without paramaters. It initialises all attributes, and assigns the correspondant informaiton
     * provided by the Configuration Class.
     */
    public ConnectionDB() {
        port = 3306;
        ipAdress = "sql11.freesqldatabase.com";
        db = "sql11670409";
        userName = "sql11670409";
        password = "9dLwndtWvE";

        String jdbcUrl = "jdbc:mysql://" + ipAdress + ":" + port + "/" + userName;

        instance = null;
    }

    /**
     * Gets the context in wich the database connector has to be initialized
     *
     * @return The connection between server and database
     */
    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
            instance.connect();
        }
        return instance;
    }


    public ResultSet selectQuery(String query){
        ResultSet rs = null;
        try {
            s =(Statement) conn.createStatement();
            rs = s.executeQuery (query);

        } catch (SQLException ex) {
            System.out.println("Problema al Recuperar les dades --> " + ex.getSQLState() + "\n");
        }
        return rs;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://" + ipAdress + ":" + port + "/" + db;
            conn = DriverManager.getConnection(url, userName, password);

            if (conn != null) {
                System.out.println("ConnexiÃ³ a base de dades " + url + " ... Ok\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

            System.out.println("Problema al connecta-nos a la BBDD --> " + url + "\n");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }

    }


    /**
     * disconnect the database.
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Problema al tancar la connexiÃ³ --> " + e.getSQLState() + "\n");
        }
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_ID, name, surname, user_type, email, password FROM User";
        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

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
        } catch (Exception e) {
            e.printStackTrace(); // For debugging, consider a logging framework for production
        }
        return users;
    }


}