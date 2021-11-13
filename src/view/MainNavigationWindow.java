package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainNavigationWindow extends JFrame {

    //-----------------------------------
    private JButton btnWithdrawMoney;
    private JButton btnExit;
    private JButton btnChangePassword;
    private JPanel windowPanel;

    //-----------------------------------

    public MainNavigationWindow(){

        setContentPane(windowPanel);
        setTitle("Payment");
        setSize(650,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setButtons();
        setLocationRelativeTo(null);

    }

    public void addListener(ActionListener action){
        btnWithdrawMoney.addActionListener(action);
        btnChangePassword.addActionListener(action);
        btnExit.addActionListener(action);
    }

    public void setButtons() {
        btnWithdrawMoney.setActionCommand("1");
        btnChangePassword.setActionCommand("2");
        btnExit.setActionCommand("3");
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(windowPanel, errorMessage, " WARNING ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void displayMessage(String message){
        JOptionPane.showMessageDialog(windowPanel, message);
    }



}
