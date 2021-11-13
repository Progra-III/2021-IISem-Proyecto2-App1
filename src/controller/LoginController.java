package controller;

import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController{

    //---------------------------
    private LoginWindow loginWindow;

    //----------------------------

    public LoginController() {

        this.loginWindow = new LoginWindow();

        LoginController.ButtonListener action = new LoginController.ButtonListener();
        this.loginWindow.addListener(action);

        this.loginWindow.setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        private ButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            int valor = Integer.parseInt(e.getActionCommand());
            switch (valor) {
                case 1:
                //ACCEPT
                    MainNavigationController mainNavigationController = new MainNavigationController();
                    loginWindow.setVisible(false);
                    break;
                case 2:
                //CANCEL
                    loginWindow.setVisible(false);
                    break;
            }
        }

    }




}
