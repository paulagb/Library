package ui;

import Controllers.BookController;
import Model.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookView extends JFrame {
    private Book book;
    private JPanel contentPane;
    private JButton btReserved;
    private JButton btFavourites;
    private JButton btClose;


    /**
     * Create the frame.
     */
    public BookView() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 493, 433);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        btReserved = new JButton("");
        btFavourites = new JButton("");

    }

    public void setBook(Book book) {
        setUndecorated(true);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        btClose = new JButton("");
        btClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btClose.setEnabled(true);
        btClose.setIcon(new ImageIcon(BookView.class.getResource("/img/x.png")));
        btClose.setBackground(Color.WHITE);
        btClose.setBounds(453, 10, 30, 23);
        contentPane.add(btClose);
        this.book = book;
        JLabel lblImg = new JLabel("");
        lblImg.setBounds(28, 35, 109, 129);
        ImageIcon imageIcon = book.getImageIcon();
        lblImg.setIcon(imageIcon);
        Dimension labelSize = lblImg.getPreferredSize();
        Image image = imageIcon.getImage().getScaledInstance(labelSize.width, labelSize.height, Image.SCALE_SMOOTH);
        ImageIcon adjustedImageIcon = new ImageIcon(image);
        lblImg.setIcon(adjustedImageIcon);
        contentPane.add(lblImg);
        JLabel lblTitle = new JLabel(this.book.getTitle());
        lblTitle.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
        lblTitle.setBounds(187, 35, 91, 23);
        contentPane.add(lblTitle);

        JLabel lblAuthor = new JLabel(this.book.getAuthor());
        lblAuthor.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
        lblAuthor.setBounds(187, 82, 91, 23);
        contentPane.add(lblAuthor);

        JLabel lblGenre = new JLabel(this.book.getGenre());
        lblGenre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
        lblGenre.setBounds(187, 129, 91, 23);
        contentPane.add(lblGenre);

        JTextArea taDescription = new JTextArea();
        taDescription.setText(this.book.getDescription());
        taDescription.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
        taDescription.setEditable(false);
        taDescription.setBounds(28, 188, 442, 110);
        contentPane.add(taDescription);


        btReserved.setActionCommand("btReserved");
        if (this.book.isRented()) {
            btReserved.setEnabled(false);
        }
        btReserved.setActionCommand("btReserved");
        btReserved.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
        if (this.book.isRented()) {
            btReserved.setIcon(new ImageIcon(BookView.class.getResource("/img/x-red.png")));
            btReserved.setText("Book is not available");
        } else {
            btReserved.setIcon(new ImageIcon(BookView.class.getResource("/img/hourglass.png")));
            btReserved.setText("Reserve for 2 days");
        }
        btReserved.setHorizontalAlignment(SwingConstants.LEFT);
        btReserved.setBounds(63, 339, 298, 21);
        contentPane.add(btReserved);

        btFavourites.setActionCommand("favBook");
        btFavourites.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
        if (this.book.isFavourite()) {
            btFavourites.setIcon(new ImageIcon(BookView.class.getResource("/img/heart-red.png")));
            btFavourites.setText("Remove from favourites");
        } else {
            btFavourites.setIcon(new ImageIcon(BookView.class.getResource("/img/heart-empty.png")));
            btFavourites.setText("Add to favourites");
        }
        btFavourites.setHorizontalAlignment(SwingConstants.LEFT);
        btFavourites.setBounds(63, 378, 298, 21);
        contentPane.add(btFavourites);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(218, 165, 32));
        separator.setBounds(28, 312, 109, 2);
        contentPane.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(new Color(211, 211, 211));
        separator_1.setBounds(187, 60, 70, 2);
        contentPane.add(separator_1);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBackground(new Color(211, 211, 211));
        separator_1_1.setBounds(187, 103, 70, 2);
        contentPane.add(separator_1_1);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBackground(new Color(211, 211, 211));
        separator_1_2.setBounds(187, 151, 70, 2);
        contentPane.add(separator_1_2);
    }

    public void changeRented(Book book) {
        if (!book.isRented()) {
            book.setRented(true);
            //TO DO
            //save info into database
            btReserved.setIcon(new ImageIcon(BookView.class.getResource("/img/x-red.png")));
            btReserved.setText("Book is not available");
            btReserved.setEnabled(false);
        }
    }

    public void changeFavourite(Book book) {
        if (book.isFavourite()) {
            book.setFavourite(false);
            //TO DO
            //save info into database
            btFavourites.setIcon(new ImageIcon(BookView.class.getResource("/img/heart-empty.png")));
            btFavourites.setText("Add to favourites");
        } else {
            book.setFavourite(true);
            //TO DO
            //save info into database
            btFavourites.setIcon(new ImageIcon(BookView.class.getResource("/img/heart-red.png")));
            btFavourites.setText("Remove from favourites");
        }
    }


    public void setControllers(BookController bookController) {
        btReserved.addActionListener(bookController);
        btFavourites.addActionListener(bookController);
    }

    public void displayView(boolean b) {
        this.setVisible(b);
    }
}
