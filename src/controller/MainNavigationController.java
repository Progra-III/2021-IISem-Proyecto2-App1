package controller;

import model.Client;
import view.LoginWindow;
import view.MainNavigationWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainNavigationController {

    //-------------------------------
    private MainNavigationWindow mainNavigationWindow;
    String user;
    String password;
    Client client;

    //-------------------------------

    public MainNavigationController(String user, String password, Client client) {
        this.mainNavigationWindow = new MainNavigationWindow();

        MainNavigationController.ButtonListener action = new MainNavigationController.ButtonListener();
        this.mainNavigationWindow.addListener(action);

        this.mainNavigationWindow.setVisible(true);

        this.user = user;

        this.password = password;

        this.client = client;
    }

    private class ButtonListener implements ActionListener {

        private ButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            int valor = Integer.parseInt(e.getActionCommand());
            switch (valor) {
                case 1:
                    //HACER RETIRO
                    WithdrawalCashController withdrawalCashController = new WithdrawalCashController(user,password,client);
                    break;
                case 2:
                    //CHANGE PASSWORD
                    ChangePasswordController changePasswordController = new ChangePasswordController(user,password,client);
                    mainNavigationWindow.setVisible(false);
                    break;

                case 3:
                    //EXIT
                    client.sendMessage("Saliendo");
                    System.exit(1);
                    break;
            }
        }
    }

}
