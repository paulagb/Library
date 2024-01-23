package Model;


import java.util.ArrayList;

public class User {
    private int userID;
    private String username;
    private String name;
    private String surname;
    private String userType;
    private String password;
    private String email;
    private ArrayList<Book> rentedBooks;

    public User() {

    }

    public User(int userID, String username, String name, String surname, String userType, String password, String email) {
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.userType = userType;
        this.password = password;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
