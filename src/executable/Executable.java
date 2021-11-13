package executable;

import controller.LoginController;

public class Executable {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginController principalController= new LoginController();
            }
        });
    }
}
