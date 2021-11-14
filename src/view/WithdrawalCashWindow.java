package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class WithdrawalCashWindow extends JFrame {

   //--------------------------------------------
    private JTextField txtFAccountBalance;
    private JTextField txtFMoutRemoved;
    private JTextField txtFResult;
    private JButton btnClean;
    private JButton btnExit;
    private JButton btnAccept;
    private JPanel windowPanel;

    //--------------------------------------------


    public WithdrawalCashWindow(){

        setContentPane(windowPanel);
        setTitle("Pantalla de Retiro de Dinero");
        setSize(650,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setButtons();
        setLocationRelativeTo(null);
    }

    public JTextField getTxtFAccountBalance() {
        return txtFAccountBalance;
    }

    public JTextField getTxtFMoutRemoved() {
        return txtFMoutRemoved;
    }

    public JTextField getTxtFResult() {
        return txtFResult;
    }

    public void cleanTxtFAccountBalance(){
        txtFAccountBalance.setText(null);
    }

    public void cleanTxtFMountRemoved(){
        txtFMoutRemoved.setText(null);
    }

    public void cleanTxtFResult(){
        txtFResult.setText(null);
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
