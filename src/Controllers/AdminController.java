package Controllers;

import Database.DAO.BookDAO;
import Model.Book;
import Model.User;
import service.Library;
import ui.AddBook;
import ui.BookAdded;
import ui.MainAdmin;
import ui.Users;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminController implements ActionListener {
    private MainAdmin view;
    private AddBook addBookView;
    private BookAdded bookAddedView;
    private Users usersView;
    private Library logic;
    private User user;

    public AdminController(MainAdmin loginView, Library logic) {
        this.view = loginView;
        this.logic = logic;
        //loginView.showView(true);
    }

    public void setAddBookView(AddBook addBookView) {
        this.addBookView = addBookView;
    }

    public void setBookAddedView(BookAdded bookAddedView) {
        this.bookAddedView = bookAddedView;
    }

    public void setUsersView(Users usersView) {
        this.usersView = usersView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btAdd" -> {
                if ( logic.addBook(addBookView.getBook())){
                    logic.changeView("bookAdded");
                }
            }
            case "btDiscard" -> {
                logic.changeView("discardAddBook");
            }
            case "btImage" -> System.out.println("image");
            case "adminUsers" -> {
                logic.changeView("adminUsers");
            }
            case "btAddBook" -> {
                logic.changeView("addBook");
            }
            case "btSearchMain" -> {
                System.out.println("searching");
                view.setBooks(logic.search(view.getSearch()));
                view.refresh();
                //TODO REFRESH MAIN CUSTOMER VIEW, PARA QUE SALGA LA SEARCH
            }
            case "btBack" -> {
                logic.changeView("mainPage");
            }
        }


    }

    public void displayView(boolean b) {

        view.showView(b);
    }

    public void displayAddBookview(boolean b) {
        addBookView.showView(b);
    }

    public void setUser(User user) {
        this.user = user;
    }



    public void displaybookAddedview(boolean b) {
        bookAddedView.showView(b);
    }

    public void displayUsersView(boolean b) {
        usersView.showView(b);
    }

    public void getBooks(User user) {
        ArrayList<Book> books = new ArrayList<>();
        BookDAO bookDAO = new BookDAO();
        books = (ArrayList<Book>) bookDAO.getBooks(user.getUserID());
        view.setBooks(books);
    }
}

