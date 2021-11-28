package controller;

import model.Client;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController{

    //---------------------------
    private LoginWindow loginWindow;
    private Client client;

    //----------------------------

    public LoginController() {

        client = new Client();

        this.loginWindow = new LoginWindow();

        LoginController.ButtonListener action = new LoginController.ButtonListener();
        this.loginWindow.addListener(action);

        this.loginWindow.setVisible(true);

        serverConnect();
    }

    //------------------------------
    public static boolean isNumeric(char data){
        try {
            Integer.parseInt(String.valueOf(data));
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public static boolean comparePasswords(String password, String password2){
        if(password == password2){
            return true;
        }
        return false;
    }

    public static boolean validatePassword(String password){

        boolean length = false;
        boolean number = false;
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean specialCharacters = false;

        if(password.length()>=8){
            length = true;
        }

        for(char i : password.toCharArray()){

            if(LoginController.isNumeric(i)){
                number = true;
            }

            if(Character.isLowerCase(i)){
                lowerCase = true;
            }

            if(Character.isUpperCase(i)){
                upperCase = true;
            }

            if(!Character.isJavaLetter(i)){
                specialCharacters = true;
            }
        }

        if(length && number && lowerCase && upperCase && specialCharacters){
            return true;
        }
        return false;
    }

    public void serverConnect(){
        client.connectServer();
        client.createDataFlow();
        client.start();
    }

    private class ButtonListener implements ActionListener {

        private ButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            int valor = Integer.parseInt(e.getActionCommand());
            switch (valor) {
                case 1:
                //ACCEPT
                    String user = loginWindow.getTxtFUser();
                    String password = String.valueOf(loginWindow.getTxtFPassword());

                    if(LoginController.validatePassword(password)) {
                          client.sendMessage("login");
                          client.sendMessage(user);
                          client.sendMessage(password);

                        if (client.receive().equals("Correcto")) {
                            loginWindow.displayMessage("Procesado correctamente.");

                            MainNavigationController mainNavigationController = new MainNavigationController(user,password,client);
                            loginWindow.dispose();
                        }else{
                            loginWindow.displayMessage("No entro >:c");
                        }
                    }
                    else{
                        loginWindow.displayErrorMessage("INGRESE UNA CONTRASEÑA SEGURA.");
                    }

                    break;
                case 2:
                //CANCEL
                    loginWindow.dispose();
                    break;
            }
        }

    }




}
