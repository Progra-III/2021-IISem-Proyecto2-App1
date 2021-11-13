package controller;

import model.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientController {

    //---------------------------
    private List<Client> clientList;

    private static ClientController instance = null;

    //---------------------------

    public ClientController() {
        upload();
    }

    public void upload() {
        clientList = new ArrayList<Client>();
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Boolean clientListIsEmpty() {
        if (clientList.isEmpty()) {
            return true;
        }
        return false;
    }

    public Boolean addClient(Client newClient) {
        if (!(clientList.contains(newClient))) {
            clientList.add(newClient);
            return true;
        }
        return false;
    }

    public Client searchClient(String id) {
        Client aux = null;

        for (int counter = 0; counter < clientList.size(); counter++) {

            if (id.equals(clientList.get(counter).getId())) {
                aux = clientList.get(counter);
            }
        }
        return aux;
    }

    public Boolean containsClient(String id) {

        for (int counter = 0; counter < clientList.size(); counter++) {

            if (id.equals(clientList.get(counter).getId())) {
                return true;
            }
        }
        return false;
    }

}





