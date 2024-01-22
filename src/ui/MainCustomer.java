package ui;

import Controllers.MainPageCustomerController;
import Model.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainCustomer extends JFrame {

    private static final long serialVersionUID = 1L;
    private ArrayList<Book> books;
    private JPanel contentPane;
    private JTextField tfSearch;
    private JButton btSearch;
    private JButton btProfile;
    private JButton btFavorites;


    /**
     * Create the frame.
     */
    public MainCustomer() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainCustomer.class.getResource("/img/icono.jpg")));
        setTitle("Library\u2122");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 989, 578);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel pnBar = new JPanel();
        pnBar.setBackground(new Color(70, 130, 180));
        pnBar.setBounds(0, 0, 975, 57);
        contentPane.add(pnBar);
        pnBar.setLayout(null);

        JLabel lblLibrary = new JLabel("Library\u2122");
        lblLibrary.setForeground(new Color(255, 255, 255));
        lblLibrary.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 18));
        lblLibrary.setBounds(50, 10, 98, 24);
        pnBar.add(lblLibrary);

        tfSearch = new JTextField("Search by book or author");
        tfSearch.setForeground(Color.GRAY);

        tfSearch.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfSearch.getText().equals("Search by book or author")) {
                    tfSearch.setText("");
                    tfSearch.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfSearch.getText().trim().isEmpty()) {
                    tfSearch.setText("Search by book or author");
                    tfSearch.setForeground(Color.GRAY);
                }
            }

        });
        tfSearch.setFont(new Font("Leelawadee", Font.PLAIN, 14));
        tfSearch.setBounds(289, 14, 209, 26);
        pnBar.add(tfSearch);
        tfSearch.setColumns(10);

        btSearch = new JButton("");
        btSearch.setActionCommand("btSearch");
        btSearch.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/magnifying-glass.png")));
        btSearch.setForeground(new Color(255, 255, 255));
        btSearch.setBackground(new Color(218, 165, 32));
        btSearch.setBounds(256, 14, 33, 26);
        pnBar.add(btSearch);

        btProfile = new JButton("");
        btProfile.setActionCommand("btProfile");
        btProfile.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/user.png")));
        btProfile.setBackground(new Color(70, 130, 180));
        btProfile.setForeground(new Color(0, 0, 0));
        btProfile.setBounds(888, -3, 66, 59);
        pnBar.add(btProfile);


        btFavorites = new JButton("");
        btFavorites.setActionCommand("btFavourites");
        btFavorites.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/heart.png")));
        btFavorites.setForeground(Color.BLACK);
        btFavorites.setBackground(new Color(70, 130, 180));
        btFavorites.setBounds(819, -3, 59, 59);
        pnBar.add(btFavorites);

        JPanel pnTitle = new JPanel();
        pnTitle.setBounds(0, 55, 975, 118);
        contentPane.add(pnTitle);
        pnTitle.setLayout(null);

        JLabel lblExplore = new JLabel("Explore");
        lblExplore.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
        lblExplore.setBounds(398, 35, 90, 45);
        pnTitle.add(lblExplore);

        JLabel lblImgExplore = new JLabel("");
        lblImgExplore.setBounds(498, 10, 127, 98);
        lblImgExplore.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/books.png")));
        lblImgExplore.setHorizontalAlignment(JLabel.CENTER);
        lblImgExplore.setVerticalAlignment(JLabel.CENTER);
        pnTitle.add(lblImgExplore);

        JScrollPane spBooks = new JScrollPane();
        spBooks.setBackground(new Color(255, 255, 255));
        spBooks.setBounds(152, 200, 653, 311);
        contentPane.add(spBooks);

        JPanel pnBooks = new JPanel();
        pnBooks.setBackground(new Color(255, 255, 255));
        spBooks.setViewportView(pnBooks);
        pnBooks.setLayout(new GridLayout(0, 1, 0, 0));

        //TO DO
        //CHANGE METHOD TO ACCESS BOOKS
        /*
        PanelBook element;
        for(int i = 0; i < library.getNumberOfBooks(); i++) {
            element = new PanelBook(library.getAllBooks()[i]);
            element.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //show BookView
                }
            });
            pnBooks.add(element);
        }

         */
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
       /* for (Book book : books) {
            System.out.println(book.getBookId() + book.getAuthor() + book.getDescription() + book.getGenre() + book.isReserved() + book.isRented() + book.isFavourite()  );
        }*/
    }

    public void showView(boolean state) {
        setVisible(state);
    }

    public void setControllers(MainPageCustomerController mainPageCustomerController) {
        btSearch.addActionListener(mainPageCustomerController);
        btProfile.addActionListener(mainPageCustomerController);
        btFavorites.addActionListener(mainPageCustomerController);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String getSearch() {
        return tfSearch.getText();
    }
}
