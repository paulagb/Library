package ui;

import Model.Book;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelRentedBook extends JPanel {

    Book book;

    JButton btReturned;

    /**
     * Create the panel.
     */
    public PanelRentedBook(Book book) {
        setLayout(null);
        this.book = book;

        JLabel lblTitle = new JLabel(book.getTitle() + "-" + book.getAuthor());
        lblTitle.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
        lblTitle.setBounds(26, 10, 380, 21);
        add(lblTitle);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(184, 134, 11));
        separator.setBounds(25, 33, 393, 2);
        add(separator);

        JLabel lblWhenRented = new JLabel("When rented:");
        lblWhenRented.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        lblWhenRented.setBounds(26, 51, 90, 13);
        add(lblWhenRented);

        JLabel lblDeadline = new JLabel("Deadline:");
        lblDeadline.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        lblDeadline.setBounds(26, 74, 66, 13);
        add(lblDeadline);

        JLabel lblRentedDate = new JLabel(book.getRentedDate());
        lblRentedDate.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        lblRentedDate.setBounds(340, 51, 66, 13);
        add(lblRentedDate);

        JLabel lblDeadlineDate = new JLabel(book.getDeadlineDate());
        lblDeadlineDate.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        lblDeadlineDate.setBounds(340, 74, 66, 13);
        add(lblDeadlineDate);

        btReturned = new JButton("Mark as returned");
        btReturned.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TO DO
                //return book
            }
        });
        btReturned.setForeground(new Color(255, 255, 255));
        btReturned.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
        btReturned.setBackground(new Color(216, 191, 216));
        btReturned.setBounds(117, 127, 185, 21);
        add(btReturned);

    }

    public JButton getBtReturned() {
        return btReturned;
    }
}
