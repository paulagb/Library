package service;

public class Library {

    public Library() {

    }

    public boolean checkCredentials(String user, String password) {
        return true; //library method that check user data base
    }

    public boolean checkIfProfileExists(String email) {
        return false; //method that checks in data base if an account already exists
    }

    public void createProfile(String name, String email, String password) {
        //method that creates a new profile
    }

}

