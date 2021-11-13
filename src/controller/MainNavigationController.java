package controller;

import view.LoginWindow;
import view.MainNavigationWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainNavigationController {

    //-------------------------------
    private MainNavigationWindow mainNavigationWindow;

    //-------------------------------

    public MainNavigationController() {
        this.mainNavigationWindow = new MainNavigationWindow();

        MainNavigationController.ButtonListener action = new MainNavigationController.ButtonListener();
        this.mainNavigationWindow.addListener(action);

        this.mainNavigationWindow.setVisible(true);

    }

    private class ButtonListener implements ActionListener {

        private ButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            int valor = Integer.parseInt(e.getActionCommand());
            switch (valor) {
                case 1:
                    //HACER RETIRO
                    WithdrawalCashController withdrawalCashController = new WithdrawalCashController();
                    break;
                case 2:
                    //CHANGE PASSWORD
                    ChangePasswordController changePasswordController = new ChangePasswordController();
                    mainNavigationWindow.setVisible(false);
                    break;

                case 3:
                    //EXIT
                    LoginController loginController = new LoginController();
                    mainNavigationWindow.setVisible(false);
                    break;
            }
        }
    }

}
