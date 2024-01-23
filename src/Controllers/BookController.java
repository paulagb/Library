package Controllers;

import Model.Book;
import service.Library;
import ui.BookView;
import ui.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookController implements ActionListener {

    private BookView bookView;
    private Library logic;

    public BookController(BookView loginView, Library logic) {
        this.bookView = loginView;
        this.logic = logic;
        //loginView.showView(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btReserved" -> {
                logic.changeView("reserved");
            }
            case "btFavourites" -> {
                logic.changeView("favourites");
            }
        }
    }

    public void showBook(Book book) {
        bookView.setBook(book);
        bookView.displayView(true);
    }


}

