import Database.ConnectionDB;

public class Main {

    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();
        connectionDB.connect();

        Logic logic = new Logic();

        logic.getAllUsers();


    }
}
