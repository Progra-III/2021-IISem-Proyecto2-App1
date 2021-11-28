package controller;


import model.Client;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawalCashController {

    //-----------------------------------
    WithdrawalCashWindow withdrawalCashWindow;
    String user;
    String password;
    Client client;

    //------------------------------------

    public WithdrawalCashController(String user, String password, Client client) {
        this.withdrawalCashWindow = new WithdrawalCashWindow();

        WithdrawalCashController.ButtonListener action = new WithdrawalCashController.ButtonListener();
        this.withdrawalCashWindow.addListener(action);

        this.withdrawalCashWindow.setVisible(true);

        this.user = user;

        this.password = password;

        this.client = client;

        client.sendMessage("saldo");
        client.sendMessage(user);
        client.sendMessage(password);

        withdrawalCashWindow.setTxtFAccountBalance(client.receiveTransaction());
    }

    public static boolean isNumeric(String data){
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
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
                    MainNavigationController mainNavigationController = new MainNavigationController(user,password,client);
                    withdrawalCashWindow.dispose();
                    break;

                case 3:
                    //ACCEPT
                    String amountRemoved = withdrawalCashWindow.getTxtFMountRemoved();
                    if(WithdrawalCashController.isNumeric(amountRemoved)){

                        if(Integer.parseInt(withdrawalCashWindow.getTxtFAccountBalance()) >= Integer.parseInt(amountRemoved)){

                            int result = Integer.parseInt(withdrawalCashWindow.getTxtFAccountBalance()) - Integer.parseInt(amountRemoved);
                            client.sendMessage("retiro");
                            client.sendMessage(user);
                            client.sendMessage(password);
                            client.sendMessage(String.valueOf(result));

                            withdrawalCashWindow.setTxtFAccountBalance(client.receive());

                            withdrawalCashWindow.setTxtFResult("Retiro exitoso.");

                            withdrawalCashWindow.displayMessage("Retire su dinero.");
                        }else{
                            withdrawalCashWindow.displayErrorMessage("Saldo insuficiente!");
                        }

                    }else{
                        withdrawalCashWindow.displayErrorMessage("Ingrese un valor numérico.");
                        withdrawalCashWindow.cleanTxtFMountRemoved();
                    }

                    break;

            }
        }
    }



}
