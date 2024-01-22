package ui;

import Model.User;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class PanelUser extends JPanel {

    User user;
    private JTextField tfBookToAdd;
    private JButton btAdd;
    private JButton btNoAdd;

    /**
     * Create the panel.
     */
    public PanelUser(User userToShow) {
        this.user = userToShow;
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        JLabel lblName = new JLabel(user.getName());
        lblName.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        lblName.setBounds(10, 10, 381, 21);
        add(lblName);

        JLabel lblEmail = new JLabel(user.getEmail());
        lblEmail.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        lblEmail.setBounds(10, 33, 381, 21);
        add(lblEmail);

        JButton btAddBook = new JButton("Add book");
        btAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfBookToAdd.setVisible(true);
                btAdd.setVisible(true);
                btNoAdd.setVisible(true);
            }
        });
        btAddBook.setForeground(new Color(255, 255, 255));
        btAddBook.setBackground(new Color(65, 105, 225));
        btAddBook.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        btAddBook.setBounds(10, 68, 430, 21);
        add(btAddBook);

        JLabel lblRentedBooks = new JLabel("Rented Books:");
        lblRentedBooks.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        lblRentedBooks.setBounds(10, 134, 99, 13);
        add(lblRentedBooks);

        tfBookToAdd = new JTextField();
        tfBookToAdd.setText("Write title of the book...");
        tfBookToAdd.setFont(new Font("Leelawadee U"
                + "I Semilight", Font.PLAIN, 12));
        tfBookToAdd.setBounds(13, 99, 336, 19);
        tfBookToAdd.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfBookToAdd.getText().equals("Write title of the book...")) {
                    tfBookToAdd.setText("");
                    tfBookToAdd.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfBookToAdd.getText().trim().isEmpty()) {
                    tfBookToAdd.setText("Write title of the book...");
                    tfBookToAdd.setForeground(Color.GRAY);
                }
            }

        });
        add(tfBookToAdd);
        tfBookToAdd.setVisible(false);
        tfBookToAdd.setEnabled(false);
        tfBookToAdd.setColumns(10);

        btAdd = new JButton("");
        btAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TO DO
                //add book to user
                tfBookToAdd.setVisible(false);
                btAdd.setVisible(false);
                btNoAdd.setVisible(false);
            }
        });
        btAdd.setIcon(new ImageIcon(PanelUser.class.getResource("/img/tick-white.png")));
        btAdd.setBackground(new Color(124, 252, 0));
        btAdd.setBounds(373, 99, 30, 21);
        add(btAdd);
        btAdd.setVisible(false);
        btAdd.setEnabled(false);

        btNoAdd = new JButton("");
        btNoAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfBookToAdd.setVisible(false);
                btAdd.setVisible(false);
                btNoAdd.setVisible(false);
                tfBookToAdd.setEnabled(false);
                btAdd.setEnabled(false);
                btNoAdd.setEnabled(false);
            }
        });
        btNoAdd.setIcon(new ImageIcon(PanelUser.class.getResource("/img/x-white.png")));
        btNoAdd.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
        btNoAdd.setBackground(new Color(255, 0, 0));
        btNoAdd.setBounds(410, 99, 30, 21);
        add(btNoAdd);
        btNoAdd.setVisible(false);
        btAdd.setEnabled(false);

        JScrollPane spRentedBooks = new JScrollPane();
        spRentedBooks.setBounds(20, 157, 420, 146);
        add(spRentedBooks);

        JPanel pnRentedBooks = new JPanel();
        pnRentedBooks.setBackground(new Color(255, 255, 255));
        spRentedBooks.setViewportView(pnRentedBooks);
        pnRentedBooks.setLayout(new GridLayout(0, 1, 0, 0));

        //TO DO
        //METHOD TO ACCESS TO RENTED BOOKS BY USER
        /*

        if(user.getNumberOfRentedBooks() > 0) {
            PanelRentedBook element;
            for(int i = 0; i < user.getNumberOfRentedBooks(); i++) {
                element = new PanelRentedBook(this,user.getRentedBooks()[i]);
                pnRentedBooks.add(element);
            }
        }

         */






    }
}
