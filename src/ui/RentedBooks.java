package ui;

import Controllers.FavouriteController;
import Controllers.RentedBookController;
import Model.Book;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RentedBooks extends JFrame {

    private JPanel contentPane;
    private JTextField tfSearch;
    private JButton btSearch;
    private JButton btProfile;
    private JButton btNotification;
    private JButton btFavorites;
    private ArrayList<Book> rentedBooks;



    /**
     * Create the frame.
     */
    public RentedBooks() {
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
        btSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //search in books list
            }
        });
        btSearch.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/magnifying-glass.png")));
        btSearch.setForeground(new Color(255, 255, 255));
        btSearch.setBackground(new Color(218, 165, 32));
        btSearch.setBounds(256, 14, 33, 26);
        pnBar.add(btSearch);

        btProfile = new JButton("");
        btProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //show rented books
            }
        });
        btProfile.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/user.png")));
        btProfile.setBackground(new Color(70, 130, 180));
        btProfile.setForeground(new Color(0, 0, 0));
        btProfile.setBounds(888, -3, 66, 59);
        pnBar.add(btProfile);

        btNotification = new JButton("");
        btNotification.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //show notifications
            }
        });
        btNotification.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/bell.png")));
        btNotification.setForeground(Color.BLACK);
        btNotification.setBackground(new Color(70, 130, 180));
        btNotification.setBounds(826, -2, 66, 59);
        pnBar.add(btNotification);

        btFavorites = new JButton("");
        btFavorites.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //show favorites
            }
        });
        btFavorites.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/heart.png")));
        btFavorites.setForeground(Color.BLACK);
        btFavorites.setBackground(new Color(70, 130, 180));
        btFavorites.setBounds(768, -2, 59, 59);
        pnBar.add(btFavorites);

        JPanel pnTitle = new JPanel();
        pnTitle.setBackground(new Color(169, 169, 169));
        pnTitle.setBounds(0, 55, 975, 118);
        contentPane.add(pnTitle);
        pnTitle.setLayout(null);

        JLabel lblRented = new JLabel("Rented books");
        lblRented.setForeground(new Color(255, 255, 255));
        lblRented.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
        lblRented.setBounds(339, 32, 165, 45);
        pnTitle.add(lblRented);

        JLabel lblImgFavorites = new JLabel("");
        lblImgFavorites.setIcon(new ImageIcon(RentedBooks.class.getResource("/img/calendar.png")));
        lblImgFavorites.setVerticalAlignment(SwingConstants.CENTER);
        lblImgFavorites.setHorizontalAlignment(SwingConstants.CENTER);
        lblImgFavorites.setBounds(495, 20, 84, 63);
        pnTitle.add(lblImgFavorites);

        JScrollPane spBooks = new JScrollPane();
        spBooks.setBackground(new Color(255, 255, 255));
        spBooks.setBounds(152, 200, 653, 311);
        contentPane.add(spBooks);
    }
    public void setControllers(RentedBookController rentedBookController) {
        btFavorites.addActionListener(rentedBookController);
        btNotification.addActionListener(rentedBookController);
        btProfile.addActionListener(rentedBookController);
        btSearch.addActionListener(rentedBookController);
    }

    public void showView(boolean b) {
        setVisible(b);
    }

    public void setRentedBooks(ArrayList<Book> books) {
        rentedBooks = books;
    }
}
