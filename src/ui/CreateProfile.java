package ui;


import Controllers.CreateProfileController;
import Controllers.LoginController;
import service.Library;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateProfile extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfName;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JPasswordField pfRPassword;
    private JButton btSubmit;
    private JButton btLoginHere;

    /**
     * Create the frame.
     */
    public CreateProfile() {
        setTitle("Library: Create profile");
        setIconImage(Toolkit.getDefaultToolkit().getImage(CreateProfile.class.getResource("/img/icono.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1011, 603);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(70, 130, 180));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(103, 57, 797, 442);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblCreateProfile = new JLabel("Create your profile");
        lblCreateProfile.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
        lblCreateProfile.setBounds(304, 21, 218, 30);
        panel.add(lblCreateProfile);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(184, 134, 11));
        separator.setBounds(44, 61, 707, 11);
        panel.add(separator);

        JLabel lblName = new JLabel("Nickname");
        lblName.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblName.setBounds(44, 99, 68, 20);
        panel.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(44, 129, 246, 30);
        panel.add(tfName);
        tfName.setColumns(10);

        JLabel lblEmail = new JLabel("Email*");
        lblEmail.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblEmail.setBounds(417, 96, 45, 26);
        panel.add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(417, 129, 334, 30);
        panel.add(tfEmail);
        tfEmail.setColumns(10);

        JLabel lblPassword = new JLabel("Password*");
        lblPassword.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblPassword.setBounds(44, 179, 96, 20);
        panel.add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(44, 209, 246, 30);
        panel.add(pfPassword);

        JLabel lblRepeat = new JLabel("Repeat Password*");
        lblRepeat.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblRepeat.setBounds(417, 179, 133, 20);
        panel.add(lblRepeat);

        pfRPassword = new JPasswordField();
        pfRPassword.setBounds(417, 209, 246, 30);
        panel.add(pfRPassword);

        btSubmit = new JButton("Submit");
        btSubmit.setActionCommand("Submit");
        btSubmit.setBackground(new Color(218, 165, 32));
        btSubmit.setForeground(new Color(255, 255, 255));
        btSubmit.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        btSubmit.setBounds(304, 286, 133, 55);
        panel.add(btSubmit);

        JLabel lblLogin = new JLabel("Already have an account?");
        lblLogin.setForeground(new Color(0, 0, 0));
        lblLogin.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
        lblLogin.setBounds(523, 337, 178, 20);
        panel.add(lblLogin);

        btLoginHere = new JButton("Log in here");
        btLoginHere.setActionCommand("Login");
        btLoginHere.setForeground(new Color(255, 255, 255));
        btLoginHere.setBackground(new Color(0, 204, 0));
        btLoginHere.setFont(new Font("Leelawadee UI", Font.BOLD, 13));
        btLoginHere.setBounds(542, 367, 119, 40);
        panel.add(btLoginHere);

    }


    public void setControllers(CreateProfileController createProfileController) {
        btSubmit.addActionListener(createProfileController);
        btLoginHere.addActionListener(createProfileController);
    }

    public void showView(boolean b) {
        setVisible(b);
    }

    public String getUsername() {
        return tfEmail.getText();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
    public String getPassword1() {
        return new String(pfPassword.getPassword());
    }


    public String getEmail() { return tfEmail.getText(); }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        dispose();
    }
}
