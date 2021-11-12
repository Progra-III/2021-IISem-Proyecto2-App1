package model;

import java.util.Objects;

public class Client {

    //---------------------------
    private String id;
    private String name;
    private String user;
    private String password;
    private String balance;

    //----------------------------

    public Client(String id, String name, String user, String password, String balance) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
        this.balance = balance;
    }

    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getName(), client.getName()) && Objects.equals(getUser(), client.getUser()) && Objects.equals(getPassword(), client.getPassword()) && Objects.equals(getBalance(), client.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUser(), getPassword(), getBalance());
    }
}
