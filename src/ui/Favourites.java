package ui;

import Controllers.FavouriteController;
import Model.Book;
import service.Library;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Favourites extends JFrame {

    private JPanel contentPane;
    private JTextField tfSearch;
    private JButton btSearch;
    private JButton btProfile;
    private JButton btNotification;
    private JButton btFavorites;
    private JPanel pnBooks;
    private ArrayList<Book> favBooks;
    private JLabel lblLibrary;
    private Library logic;


    /**
     * Create the frame.
     */
    public Favourites(Library logic) {
        this.logic = logic;
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

        lblLibrary = new JLabel("Library\u2122");
        lblLibrary.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
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

        btNotification = new JButton("");
        btNotification.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/bell.png")));
        btNotification.setForeground(Color.BLACK);
        btNotification.setBackground(new Color(70, 130, 180));
        btNotification.setBounds(826, -2, 66, 59);
        pnBar.add(btNotification);

        btFavorites = new JButton("");

        btFavorites.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/heart.png")));
        btFavorites.setActionCommand("btFav");
        btFavorites.setForeground(Color.BLACK);
        btFavorites.setBackground(new Color(70, 130, 180));
        btFavorites.setBounds(768, -2, 59, 59);
        pnBar.add(btFavorites);

        JPanel pnTitle = new JPanel();
        pnTitle.setBackground(new Color(221, 160, 221));
        pnTitle.setBounds(0, 55, 975, 118);
        contentPane.add(pnTitle);
        pnTitle.setLayout(null);

        JLabel lblFavourites = new JLabel("Favourites");
        lblFavourites.setForeground(new Color(255, 255, 255));
        lblFavourites.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
        lblFavourites.setBounds(377, 32, 127, 45);
        pnTitle.add(lblFavourites);

        JLabel lblImgFavorites = new JLabel("");
        lblImgFavorites.setIcon(new ImageIcon(Favourites.class.getResource("/img/white-heart.png")));
        lblImgFavorites.setVerticalAlignment(SwingConstants.CENTER);
        lblImgFavorites.setHorizontalAlignment(SwingConstants.CENTER);
        lblImgFavorites.setBounds(498, 26, 84, 63);
        pnTitle.add(lblImgFavorites);

        JScrollPane spBooks = new JScrollPane();
        spBooks.setBackground(new Color(255, 255, 255));
        spBooks.setBounds(152, 200, 653, 311);
        contentPane.add(spBooks);

        pnBooks = new JPanel();
        pnBooks.setBackground(new Color(255, 255, 255));
        spBooks.setViewportView(pnBooks);


    }

    public void setLogic(Library logic) {
        this.logic = logic;
    }

    public void setControllers(FavouriteController favController) {
        btFavorites.addActionListener(favController);
        btNotification.addActionListener(favController);
        btProfile.addActionListener(favController);
        btSearch.addActionListener(favController);
        lblLibrary.addMouseListener(favController);
    }

    public void setFavBooks(ArrayList<Book> books) {
        favBooks = books;
        PanelBook element;
        for (Book book : favBooks) {
            element = new PanelBook(book);
            element.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    BookView bookView = new BookView(logic);
                    bookView.setBook(book);
                    bookView.setVisible(true);
                }
            });
            pnBooks.add(element);
        }


    }
}
