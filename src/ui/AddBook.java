package ui;

import Model.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AddBook extends JFrame {

    private JPanel contentPane;
    private JButton btAdd;
    private JButton btDiscard;
    private JButton btImage;
    private JTextArea taGenre;
    private JTextArea taAuthor;
    private JTextArea taTitle;
    private JTextArea taDescription;


    /**
     * Create the frame.
     */
    public AddBook() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 493, 433);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.menu);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setUndecorated(true);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        taDescription = new JTextArea();
        taDescription.setText("Description...");
        taDescription.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
        taDescription.setEditable(true);
        taDescription.setBounds(28, 188, 442, 110);
        taDescription.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (taDescription.getText().equals("Description...")) {
                    taDescription.setText("");
                    taDescription.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (taDescription.getText().trim().isEmpty()) {
                    taDescription.setText("Description...");
                    taDescription.setForeground(Color.GRAY);
                }
            }

        });
        contentPane.add(taDescription);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(new Color(211, 211, 211));
        separator_1.setBounds(187, 71, 70, 2);
        contentPane.add(separator_1);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBackground(new Color(211, 211, 211));
        separator_1_1.setBounds(187, 107, 70, 2);
        contentPane.add(separator_1_1);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBackground(new Color(211, 211, 211));
        separator_1_2.setBounds(187, 151, 70, 2);
        contentPane.add(separator_1_2);

        btAdd = new JButton("Add");
        btAdd.setActionCommand("btAdd");
        btAdd.setForeground(new Color(255, 255, 255));
        btAdd.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
        btAdd.setBackground(new Color(50, 205, 50));
        btAdd.setBounds(107, 336, 122, 27);
        contentPane.add(btAdd);

        btDiscard = new JButton("Discard");
        btDiscard.setActionCommand("btDiscard");

        btDiscard.setForeground(new Color(255, 255, 255));
        btDiscard.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
        btDiscard.setBackground(new Color(255, 0, 0));
        btDiscard.setBounds(250, 336, 122, 27);
        contentPane.add(btDiscard);

        btImage = new JButton("+");
        btImage.setActionCommand("btImage");

        btImage.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btImage.setBounds(28, 39, 132, 125);
        contentPane.add(btImage);

        taTitle = new JTextArea();
        taTitle.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
        taTitle.setText("Title");
        taTitle.setBounds(187, 39, 79, 22);
        taTitle.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (taTitle.getText().equals("Title")) {
                    taTitle.setText("");
                    taTitle.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (taTitle.getText().trim().isEmpty()) {
                    taTitle.setText("Title");
                    taTitle.setForeground(Color.GRAY);
                }
            }

        });
        contentPane.add(taTitle);

        taAuthor = new JTextArea();
        taAuthor.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
        taAuthor.setBounds(187, 83, 79, 22);
        taAuthor.setText("Author");
        taAuthor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (taAuthor.getText().equals("Author")) {
                    taAuthor.setText("");
                    taAuthor.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (taAuthor.getText().trim().isEmpty()) {
                    taAuthor.setText("Author");
                    taAuthor.setForeground(Color.GRAY);
                }
            }

        });
        contentPane.add(taAuthor);

        taGenre = new JTextArea();
        taGenre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
        taGenre.setBounds(187, 119, 79, 22);
        taGenre.setText("Genre");
        taGenre.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (taGenre.getText().equals("Genre")) {
                    taGenre.setText("");
                    taGenre.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (taGenre.getText().trim().isEmpty()) {
                    taGenre.setText("Genre");
                    taGenre.setForeground(Color.GRAY);
                }
            }

        });
        contentPane.add(taGenre);
    }

    public void setControllers(ActionListener listener) {
        btAdd.addActionListener(listener);
        btDiscard.addActionListener(listener);
        btImage.addActionListener(listener);
    }

    public void showView(boolean state) {
        setVisible(state);

    }

    public Book getBook() {

        String title = taTitle.getText();
        String author = taAuthor.getText();
        String genre = taGenre.getText();
        String description = taDescription.getText();
        String image = btImage.getText();
        Book book = new Book(title, author, genre, description, image);
        return book;
    }
}
