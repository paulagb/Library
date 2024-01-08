package ui;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btLogin;
    private JButton btRegister;


    /**
     * Create the frame.
     */
    public Login() {
        configureView();
    }

    public void configureView() {
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
        pnLogin.setBounds(269, 36, 415, 452);
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

        btLogin = new JButton("Log in");
        btLogin.setName("btLogin");
        btLogin.setActionCommand("btLogin"); //ACTION LISTENER PARA GESTIONARLO EN EL CONTROLLER
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

        JLabel lblRegister = new JLabel("Don't have an account?");
        lblRegister.setFont(new Font("Leelawadee UI", Font.PLAIN, 12));
        lblRegister.setBounds(64, 380, 130, 23);
        pnLogin.add(lblRegister);

        btRegister = new JButton("Register here");
        btRegister.setActionCommand("register");
        btRegister.setForeground(new Color(255, 255, 255));
        btRegister.setBackground(new Color(0, 204, 0));
        btRegister.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
        btRegister.setBounds(204, 373, 130, 35);
        pnLogin.add(btRegister);


    }

    public void showView(boolean state) {
        setVisible(state);
    }

    public void setControllers(ActionListener actionListener) {
        this.btLogin.addActionListener(actionListener);
        this.btRegister.addActionListener(actionListener);
    }

    public String getUsername() {
        return tfEmail.getText();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
