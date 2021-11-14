package model;

public class Transaction {

    //-----------------------------------
    private String idTransaction;
    private String idClient;
    private double transactionAmount;
    private String idType;

    //------------------------------------

    public Transaction(String idTransaction, String idClient, double transactionAmount, String idType) {
        this.idTransaction = idTransaction;
        this.idClient = idClient;
        this.transactionAmount = transactionAmount;
        this.idType = idType;
    }



}
