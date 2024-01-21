package Controllers;

import Database.DAO.BookDAO;
import Model.Book;
import service.Library;
import ui.Favourites;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FavouriteController implements ActionListener {
    private Favourites favView;
    private Library logic;


    public FavouriteController(Favourites favoureitesView, Library logic) {
        this.favView = favoureitesView;
        this.logic = logic;
    }


    public void setFavBooks(String userEmail) {
        BookDAO bookDAO = new BookDAO();
        //ArrayList<Book> favBooks = bookDAO.getFavouriteBooks(userEmail);
        ArrayList<Book> books = bookDAO.getReservedBooks(userEmail);
        System.out.println("---RESERVED BOOKS");
        for (Book b: books
             ) {
            System.out.println(b.getBookId() + " " + b.getTitle() + " " + b.getAuthor());

        }
        favView.setFavBooks(books);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "btProfile" -> logic.changeView("profile");
            case "btSearch" -> {
                System.out.println("searching");
                //TODO descomentar
                //favView.setBooks(logic.search(mainCustomerView.getSearch()));
                //TODO REFRESH MAIN CUSTOMER VIEW, PARA QUE SALGA LA SEARCH

            }
            case "btFavourites" -> logic.changeView("favourites");
        }

    }

    public void displayView(boolean visible) {
        favView.setVisible(visible);
    }
}
