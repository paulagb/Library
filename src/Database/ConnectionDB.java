package Database;

import java.sql.*;

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
        db = "sql11673817";
        userName = "sql11673817";
        password = "HSUv2TDPgn";

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


    public ResultSet selectQuery(String query) {
        ResultSet rs = null;
        try {
            s = conn.createStatement();
            rs = s.executeQuery(query);

        } catch (SQLException ex) {
            System.out.println("select error database --> " + ex.getSQLState() + "\n");
        }
        return rs;
    }

    public boolean insertQuery(String query) {
        int rowsInserted = 0;
        try {
            s = conn.createStatement();
            rowsInserted = s.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println("Insertion error database --> " + ex.getSQLState() + "\n");
        }
        return rowsInserted > 0;
    }

    public boolean updateQuery (String query){
        try {
            s =(Statement) conn.createStatement();
            s.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema al Modificar --> " + ex.getSQLState() + "\n");
            return false;
        }
    }

    public boolean deleteQuery(String query) {
        try {
            s =(Statement) conn.createStatement();
            s.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema al Modificar --> " + ex.getSQLState() + "\n");
            return false;
        }
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


}
