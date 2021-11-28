package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {

    //---------------------------------
    private JButton btnCancel;
    private JButton btnAccept;
    private JPasswordField txtFPassword;
    private JTextField txtFUser;
    private JLabel labelUser;
    private JLabel labelPassword;
    private JPanel windowPanel;

    //----------------------------------

    public LoginWindow(){
        setContentPane(windowPanel);
        setTitle("Pantalla de Login");
        setSize(650,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setButtons();
        setLocationRelativeTo(null);

    }

    public char[] getTxtFPassword() {
        return txtFPassword.getPassword();
    }

    public String getTxtFUser() {
        return txtFUser.getText();
    }

    public void addListener(ActionListener action){
        btnCancel.addActionListener(action);
        btnAccept.addActionListener(action);
    }

    public void setButtons() {
        btnCancel.setActionCommand("2");
        btnAccept.setActionCommand("1");
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(windowPanel, errorMessage, " WARNING ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void displayMessage(String message){
        JOptionPane.showMessageDialog(windowPanel, message);
    }


//end
}
