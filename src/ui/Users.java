package ui;

import Controllers.AdminController;
import Model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Users extends JFrame {

    private JPanel contentPane;
    private JTextField tfSearch;
    private JButton btSearch;
    private JButton btProfile;
    private JButton btAddBook;
    private JPanel pnUsers;


    /**
     * Create the frame.
     */
    public Users() {
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
        lblLibrary.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TO DO
                //go to MainAdmin
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
        pnTitle.setBackground(new Color(169, 169, 169));
        pnTitle.setBounds(0, 55, 975, 118);
        contentPane.add(pnTitle);
        pnTitle.setLayout(null);

        JLabel lblUsersTitle = new JLabel("Users");
        lblUsersTitle.setForeground(new Color(255, 255, 255));
        lblUsersTitle.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 26));
        lblUsersTitle.setBounds(421, 34, 80, 45);
        pnTitle.add(lblUsersTitle);

        JLabel lblImgBooks = new JLabel("");
        lblImgBooks.setBounds(489, 22, 91, 72);
        lblImgBooks.setIcon(new ImageIcon(Users.class.getResource("/img/people-working.png")));
        lblImgBooks.setHorizontalAlignment(JLabel.CENTER);
        lblImgBooks.setVerticalAlignment(JLabel.CENTER);
        pnTitle.add(lblImgBooks);

        JScrollPane spUsers = new JScrollPane();
        spUsers.setBackground(new Color(255, 255, 255));
        spUsers.setBounds(119, 184, 711, 347);
        contentPane.add(spUsers);

        pnUsers = new JPanel();
        pnUsers.setBackground(new Color(255, 255, 255));
        spUsers.setViewportView(pnUsers);
        pnUsers.setLayout(new GridLayout(0, 1, 0, 0));

        //TO DO
        //METHOD TO ACCESS TO USERS
        /*
        PanelUser element;
        for(int i = 0; i < library.getNumberOfUsers(); i++) {
            element = new PanelUser(library.getUsers()[i]);
            pnUsers.add(element);
        }

         */
    }

    public void setActionListener(ActionListener actionListener) {
        btSearch.addActionListener(actionListener);
        btProfile.addActionListener(actionListener);
        btAddBook.addActionListener(actionListener);
    }

    public void setUsers(ArrayList<User> users) {
        PanelUser element;
        for (User user : users) {
            element = new PanelUser(user);
            pnUsers.add(element);
        }
    }

    public void setControllers(AdminController mainAdminController) {
        btSearch.addActionListener(mainAdminController);
        btProfile.addActionListener(mainAdminController);
        btAddBook.addActionListener(mainAdminController);
    }

    public void showView(boolean b) {
        setVisible(b);
    }
}
