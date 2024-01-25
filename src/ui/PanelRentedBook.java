package ui;

import Model.Book;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class PanelRentedBook extends JPanel {

    JButton btReturned;
    /**
     * Create the panel.
     */
    public PanelRentedBook(Book book) {
        setBorder(new LineBorder(new Color(218, 165, 32), 2));
        setBackground(new Color(255, 255, 255));
        setLayout(new GridLayout(3, 0, 0, 0));

        JLabel lblTitle = new JLabel(book.getTitle() + "-" + book.getAuthor());
        lblTitle.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
        add(lblTitle);

        JPanel pnDates = new JPanel();
        pnDates.setBackground(new Color(255, 255, 255));
        add(pnDates);
        pnDates.setLayout(new GridLayout(2, 0, 0, 0));

        JLabel lblWhenRented = new JLabel("When rented:" + "\t" + book.getRentedDate());
        lblWhenRented.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        pnDates.add(lblWhenRented);

        JLabel lblDeadline= new JLabel("Deadline:" + "\t" + book.getDeadlineDate());
        lblDeadline.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        pnDates.add(lblDeadline);

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
        add(btReturned);

    }

    public JButton getBtReturned() {
        return btReturned;
    }


}