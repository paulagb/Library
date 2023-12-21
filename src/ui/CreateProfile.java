package ui;


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
    private Library library;


    /**
     * Create the frame.
     */
    public CreateProfile(Library library) {
        this.library = library;
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
        separator.setBounds(79, 61, 631, 11);
        panel.add(separator);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblName.setBounds(44, 99, 50, 20);
        panel.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(44, 129, 218, 30);
        panel.add(tfName);
        tfName.setColumns(10);

        JLabel lblEmail = new JLabel("Email*");
        lblEmail.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblEmail.setBounds(44, 169, 45, 26);
        panel.add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(44, 205, 271, 30);
        panel.add(tfEmail);
        tfEmail.setColumns(10);

        JLabel lblPassword = new JLabel("Password*");
        lblPassword.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblPassword.setBounds(46, 245, 96, 20);
        panel.add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(44, 280, 246, 30);
        panel.add(pfPassword);

        JLabel lblRepeat = new JLabel("Repeat Password*");
        lblRepeat.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
        lblRepeat.setBounds(44, 320, 133, 20);
        panel.add(lblRepeat);

        pfRPassword = new JPasswordField();
        pfRPassword.setBounds(44, 350, 246, 30);
        panel.add(pfRPassword);

        JButton btSubmit = new JButton("Submit");
        btSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkFields();
            }

        });
        btSubmit.setBackground(new Color(218, 165, 32));
        btSubmit.setForeground(new Color(255, 255, 255));
        btSubmit.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
        btSubmit.setBounds(479, 338, 112, 37);
        panel.add(btSubmit);
    }


    @SuppressWarnings("deprecation")
    private void checkFields() {
        if(tfEmail.getText().isBlank() || pfPassword.getText().isBlank() || pfRPassword.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Some field is blank");
        } else if(!pfPassword.getText().equals(pfRPassword.getText())) {
            JOptionPane.showMessageDialog(this, "Passwords do not match");
        } else if(!library.checkIfProfileExists(tfEmail.getText())) {
            library.createProfile(tfName.getText(), tfEmail.getText(), pfPassword.getText());
            JOptionPane.showMessageDialog(this, "Profile created!");
            dispose();
        }

    }

}
