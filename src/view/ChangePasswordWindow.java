package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ChangePasswordWindow extends JFrame{

   //--------------------------------------------------
    private JPasswordField txtFNewPassword;
    private JPasswordField txtFActualPassword;
    private JPasswordField txtFConfirmPassword;
    private JButton btnClean;
    private JButton btnExit;
    private JButton btnAccept;
    private JPanel windowPanel;

    //-------------------------------------------------

    public ChangePasswordWindow(){

     setContentPane(windowPanel);
     setTitle("Cambio de Clave");
     setSize(650,400);
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     setResizable(false);
     setButtons();
     setLocationRelativeTo(null);

    }

    public char[] getTxtFNewPassword() {
        return txtFNewPassword.getPassword();
    }

    public char[] getTxtFActualPassword() {
        return txtFActualPassword.getPassword();
    }

    public char[] getTxtFConfirmPassword() {
        return txtFConfirmPassword.getPassword();
    }

    public void cleanTxtNewPassword(){
        txtFNewPassword.setText(null);
    }

    public void cleanTxtFActualPassword(){
        txtFActualPassword.setText(null);
    }

    public void cleanTxtFConfirmPassword(){
        txtFConfirmPassword.setText(null);
    }

    public void addListener(ActionListener action){
      btnClean.addActionListener(action);
      btnExit.addActionListener(action);
      btnAccept.addActionListener(action);
    }

    public void setButtons() {
      btnClean.setActionCommand("1");
      btnExit.setActionCommand("2");
      btnAccept.setActionCommand("3");
    }

    public void displayErrorMessage(String errorMessage){
       JOptionPane.showMessageDialog(windowPanel, errorMessage, " WARNING ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void displayMessage(String message){
  JOptionPane.showMessageDialog(windowPanel, message);
 }

}
