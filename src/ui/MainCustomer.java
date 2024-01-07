package UI;

import Controllers.LoginController;
import Controllers.MainPageCustomerController;
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

public class MainCustomer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btLogin;


    /**
     * Create the frame.
     */
    public MainCustomer() {
        configureView();
    }

    public void configureView(){
        setTitle("Library: Log in");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icono.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1005, 580);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(70, 130, 180));
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

    }

    public void showView(boolean state) { setVisible(state); }

    public void setControllers(MainPageCustomerController mainPageCustomerController){

    }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
