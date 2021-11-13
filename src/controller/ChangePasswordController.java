package controller;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordController {

    //---------------------------
    ChangePasswordWindow changePasswordWindow;

    //---------------------------

    ChangePasswordController() {

        this.changePasswordWindow = new ChangePasswordWindow();

        ChangePasswordController.ButtonListener action = new ChangePasswordController.ButtonListener();
        this.changePasswordWindow.addListener(action);

        this.changePasswordWindow.setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        private ButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            int valor = Integer.parseInt(e.getActionCommand());
            switch (valor) {
                case 1:
                //CLEAN TXT FIELD
                    changePasswordWindow.cleanTxtNewPassword();
                    changePasswordWindow.cleanTxtFConfirmPassword();
                    changePasswordWindow.cleanTxtFActualPassword();
                    break;
                case 2:
                //EXIT
                    MainNavigationController mainNavigationController = new MainNavigationController();
                    changePasswordWindow.setVisible(false);
                    break;

                case 3:
                //ACCEPT
                    break;

            }
        }
    }

//end
}
