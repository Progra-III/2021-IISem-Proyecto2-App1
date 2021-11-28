package controller;

import model.Client;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordController {

    //---------------------------
    ChangePasswordWindow changePasswordWindow;
    String user;
    String password;
    Client client;

    //---------------------------

    ChangePasswordController(String user, String password, Client client) {

        this.changePasswordWindow = new ChangePasswordWindow();

        ChangePasswordController.ButtonListener action = new ChangePasswordController.ButtonListener();
        this.changePasswordWindow.addListener(action);

        this.changePasswordWindow.setVisible(true);

        this.user = user;

        this.password = password;

        this.client = client;
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
        if(password.equals(password2)){
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
                    MainNavigationController mainNavigationController = new MainNavigationController(user,password,client);
                    changePasswordWindow.dispose();
                    break;

                case 3:
                //ACCEPT
                    String actualPassword = String.valueOf(changePasswordWindow.getTxtFActualPassword());
                    String newPassword = String.valueOf(changePasswordWindow.getTxtFNewPassword());
                    String confirmPassword = String.valueOf( changePasswordWindow.getTxtFConfirmPassword());

                    if(ChangePasswordController.validatePassword(newPassword)){

                        if(ChangePasswordController.comparePasswords(newPassword, confirmPassword)){

                            client.sendMessage("devuelve clave");
                            client.sendMessage(user);
                            client.sendMessage(password);

                            if(client.receive().equals(actualPassword)){

                                client.sendMessage("cambio clave");
                                client.sendMessage(user);
                                client.sendMessage(confirmPassword);

                                changePasswordWindow.displayMessage("Contraseña cambiada.");
                            }else{
                                changePasswordWindow.displayErrorMessage("Contraseña actual invalida.");
                                changePasswordWindow.cleanTxtNewPassword();
                                changePasswordWindow.cleanTxtFConfirmPassword();
                                changePasswordWindow.cleanTxtFActualPassword();
                            }

                        }else{
                            changePasswordWindow.displayMessage("Las contraseñas son diferentes. Inténtelo de nuevo");
                            changePasswordWindow.cleanTxtNewPassword();
                            changePasswordWindow.cleanTxtFConfirmPassword();
                            changePasswordWindow.cleanTxtFActualPassword();
                        }

                    }else{
                        changePasswordWindow.displayErrorMessage("Advertencia: La clave no es segura. Inténtelo de nuevo.");
                        changePasswordWindow.cleanTxtNewPassword();
                        changePasswordWindow.cleanTxtFConfirmPassword();
                        changePasswordWindow.cleanTxtFActualPassword();
                    }

                    break;

            }
        }
    }

//end
}
