package controller;


import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawalCashController {

    //-----------------------------------
    WithdrawalCashWindow withdrawalCashWindow;

    //------------------------------------

    public WithdrawalCashController() {
        this.withdrawalCashWindow = new WithdrawalCashWindow();

        WithdrawalCashController.ButtonListener action = new WithdrawalCashController.ButtonListener();
        this.withdrawalCashWindow.addListener(action);

        this.withdrawalCashWindow.setVisible(true);

    }

    private class ButtonListener implements ActionListener {

        private ButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            int valor = Integer.parseInt(e.getActionCommand());
            switch (valor) {
                case 1:
                    //CLEAN

                    withdrawalCashWindow.cleanTxtFResult();
                    withdrawalCashWindow.cleanTxtFAccountBalance();
                    withdrawalCashWindow.cleanTxtFMountRemoved();
                    break;
                case 2:
                    //EXIT

                    MainNavigationController mainNavigationController = new MainNavigationController();
                    break;

                case 3:
                    //ACCEPT

                    break;

            }
        }
    }



}
