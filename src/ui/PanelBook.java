package ui;

import Model.Book;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PanelBook extends JPanel {
    private JTextField tfTitle;
    private JTextField tfDescription;
    private JTextField tfAuthor;
    private JTextField tfGenre;

    private Book book;

    /**
     * Create the panel.
     */
    public PanelBook(Book book) {
        this.book = book;
        setBackground(new Color(255, 255, 255));
        setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblImgBook = new JLabel("");
        lblImgBook.setIcon(new ImageIcon(PanelBook.class.getResource("/img/" + this.book.getTitle() + ".png")));
        //check images name
        add(lblImgBook);

        JPanel pnInfo = new JPanel();
        pnInfo.setBackground(new Color(255, 255, 255));
        add(pnInfo);
        pnInfo.setLayout(new GridLayout(3, 0, 0, 0));

        tfTitle = new JTextField();
        tfTitle.setText(this.book.getTitle());
        tfTitle.setEditable(false);
        tfTitle.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
        pnInfo.add(tfTitle);
        tfTitle.setColumns(10);

        JPanel panel = new JPanel();
        pnInfo.add(panel);
        panel.setLayout(new GridLayout(0, 3, 0, 0));

        tfAuthor = new JTextField();
        tfAuthor.setText(this.book.getAuthor());
        tfAuthor.setEditable(false);
        tfAuthor.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
        panel.add(tfAuthor);
        tfAuthor.setColumns(10);

        JLabel lblDot = new JLabel("");
        lblDot.setHorizontalAlignment(SwingConstants.CENTER);
        lblDot.setIcon(new ImageIcon(PanelBook.class.getResource("/img/grey-dot.png")));
        lblDot.setBackground(new Color(255, 255, 255));
        panel.add(lblDot);

        tfGenre = new JTextField();
        tfGenre.setText(this.book.getGenre());
        tfGenre.setEditable(false);
        tfGenre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
        panel.add(tfGenre);
        tfGenre.setColumns(10);

        tfDescription = new JTextField();
        tfDescription.setText(this.book.getDescription());
        tfDescription.setEditable(false);
        tfDescription.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
        pnInfo.add(tfDescription);
        tfDescription.setColumns(10);

    }

}
