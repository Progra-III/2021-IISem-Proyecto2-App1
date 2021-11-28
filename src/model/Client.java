package model;

import controller.LoginController;
import controller.MainNavigationController;
import controller.WithdrawalCashController;

import java.util.Objects;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client extends Thread {

    //---------------------------

    LoginController loginController;
    MainNavigationController mainNavigationController;
    WithdrawalCashController withdrawalCashController;

    final int PUERTO = 7020;
    final String HOST = "localhost";                                                            //127.0.0.1

    public Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    //---------------------------

    public void setController(LoginController loginController){
        this.loginController = loginController;
    }

    public void connectServer(){
        try {
            socket = new Socket(HOST,PUERTO);
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void createDataFlow(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            bufferedReader = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bufferedWriter = new BufferedWriter(osw);
        } catch (IOException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void sendMessage(String usuario){
        try {
            bufferedWriter.write(usuario);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch (IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null){
                bufferedReader.close();
            }if (bufferedWriter != null){
                bufferedWriter.close();
            }if (socket != null){
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String receiveTransaction() {
        try {
            String mensaje = bufferedReader.readLine();
            return mensaje;
        }catch (IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String receiveChange() {
        try {
            String mensaje = bufferedReader.readLine();
            return mensaje;
        }catch (IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String receive(){
        try {
            String mensaje = bufferedReader.readLine();
            return mensaje;
        }catch (IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }


}
