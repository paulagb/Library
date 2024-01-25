package ui;

import Model.Book;
import service.Library;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainAdmin extends JFrame {

    private JPanel contentPane;
    private JTextField tfSearch;
    private JButton btAddBook;
    private JButton btProfile;
    private JButton btSearch;
    private JPanel pnBooks;

    private ArrayList<Book> books;
    private Library logic;

    private void setLibrery(Library logic) {
        this.logic = logic;
    }

    /**
     * Create the frame.
     */
    public MainAdmin() {
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
        btSearch.setActionCommand("btSearchMain");
        btSearch.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/magnifying-glass.png")));
        btSearch.setForeground(new Color(255, 255, 255));
        btSearch.setBackground(new Color(218, 165, 32));
        btSearch.setBounds(256, 14, 33, 26);
        pnBar.add(btSearch);

        btProfile = new JButton("");
        btProfile.setActionCommand("adminUsers");
        btProfile.setIcon(new ImageIcon(MainAdmin.class.getResource("/img/users.png")));
        btProfile.setBackground(new Color(70, 130, 180));
        btProfile.setForeground(new Color(0, 0, 0));
        btProfile.setBounds(888, -3, 66, 59);
        pnBar.add(btProfile);

        btAddBook = new JButton("");
        btAddBook.setActionCommand("btAddBook");
        btAddBook.setIcon(new ImageIcon(MainAdmin.class.getResource("/img/add.png")));
        btAddBook.setForeground(Color.BLACK);
        btAddBook.setBackground(new Color(70, 130, 180));
        btAddBook.setBounds(826, -2, 66, 59);
        pnBar.add(btAddBook);

        JPanel pnTitle = new JPanel();
        pnTitle.setBounds(0, 55, 975, 118);
        contentPane.add(pnTitle);
        pnTitle.setLayout(null);

        JLabel lblAllBooks = new JLabel("All Books");
        lblAllBooks.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
        lblAllBooks.setBounds(378, 35, 110, 45);
        pnTitle.add(lblAllBooks);

        JLabel lblImgBooks = new JLabel("");
        lblImgBooks.setBounds(498, 10, 127, 98);
        lblImgBooks.setIcon(new ImageIcon(MainCustomer.class.getResource("/img/books.png")));
        lblImgBooks.setHorizontalAlignment(JLabel.CENTER);
        lblImgBooks.setVerticalAlignment(JLabel.CENTER);
        pnTitle.add(lblImgBooks);

        JScrollPane spBooks = new JScrollPane();
        spBooks.setBackground(new Color(255, 255, 255));
        spBooks.setBounds(79, 183, 819, 348);
        contentPane.add(spBooks);

        pnBooks = new JPanel();
        pnBooks.setBackground(new Color(255, 255, 255));
        spBooks.setViewportView(pnBooks);
        pnBooks.setLayout(new GridLayout(0, 1, 0, 0));

    }

    public void setControllers(ActionListener actionListener) {
        btAddBook.addActionListener(actionListener);
        btProfile.addActionListener(actionListener);
        btSearch.addActionListener(actionListener);
    }

    public String getTfSearch() {
        return tfSearch.getText();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        for (Book book : books) {
            PanelBook element;
            element = new PanelBook(book);
            element.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    BookView bookView = new BookView(logic);
                    bookView.setControllers(logic.getBookController());
                    bookView.setBook(book);
                    bookView.setVisible(true);
                }
            });
            pnBooks.add(element);


        }
    }

    public void showView(boolean b) {
        setVisible(b);
    }

    public String getSearch() {
        return tfSearch.getText();
    }

    public void refresh() {
        pnBooks.removeAll();
        for (Book book : books) {
            PanelBook element;
            element = new PanelBook(book);
            pnBooks.add(element);
        }
    }
}
