package ui;

import Controllers.AdminController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAdded extends JFrame {

    private JPanel contentPane;
    private JButton btBack;

    /**
     * Create the frame.
     */
    public BookAdded() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 543, 195);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setUndecorated(true);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAdded = new JLabel("Book successfully added!");
        lblAdded.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 23));
        lblAdded.setBounds(133, 59, 250, 31);
        contentPane.add(lblAdded);

        btBack = new JButton("Back to main page");
        btBack.setActionCommand("btBack");
        btBack.setBackground(new Color(50, 205, 50));
        btBack.setForeground(new Color(255, 255, 255));
        btBack.setBounds(178, 112, 153, 21);
        contentPane.add(btBack);
    }

    public void setControllers(AdminController mainAdminController) {
        btBack.addActionListener(mainAdminController);

    }

    public void showView(boolean b) {
        setVisible(b);
    }
}
