package ui;

import service.Library;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;


import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private Library library;


    /**
     * Create the frame.
     */
    public Login() {
        library = new Library();
        setTitle("Library: Log in");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icono.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1005, 580);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(70, 130, 180));
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));


        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel pnLogin = new JPanel();
        pnLogin.setBackground(new Color(255, 255, 255));
        pnLogin.setBorder(new CompoundBorder());
        pnLogin.setBounds(269, 106, 415, 338);
        contentPane.add(pnLogin);
        pnLogin.setLayout(null);

        JLabel lblLibrary = new JLabel("Welcome to Library\u2122");
        lblLibrary.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
        lblLibrary.setBounds(100, 28, 210, 35);
        pnLogin.add(lblLibrary);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(218, 165, 32));
        separator.setBounds(64, 67, 270, 2);
        pnLogin.add(separator);

        JButton btLogin = new JButton("Log in");
        btLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkCredentials();
            }
        });
        btLogin.setForeground(new Color(255, 255, 255));
        btLogin.setBackground(new Color(218, 165, 32));
        btLogin.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 17));
        btLogin.setBounds(64, 279, 270, 35);
        pnLogin.add(btLogin);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 17));
        lblEmail.setBounds(64, 92, 78, 21);
        pnLogin.add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        tfEmail.setBackground(new Color(230, 230, 250));
        tfEmail.setBounds(64, 123, 270, 28);
        pnLogin.add(tfEmail);
        tfEmail.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 17));
        lblPassword.setBounds(64, 186, 78, 21);
        pnLogin.add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        pfPassword.setBackground(new Color(230, 230, 250));
        pfPassword.setBounds(64, 217, 270, 28);
        pnLogin.add(pfPassword);
    }

    @SuppressWarnings("deprecation")
    private void checkCredentials() {
        if(tfEmail.getText().isBlank() || pfPassword.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Email or password is blank");
        }
        else if(library.checkCredentials(tfEmail.getText(), pfPassword.getText())) {
            CreateProfile frame = new CreateProfile(library);
            //frame.setModal(true);    //acordarse
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Email or password does not exists");
        }
    }
}
