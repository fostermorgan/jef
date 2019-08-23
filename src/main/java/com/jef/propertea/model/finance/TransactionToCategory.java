package main.java.propertea.model.finance;

public class TransactionToCategory {

    private int transaction_to_category_ID;
    private int transactionID;
    private int categoryID;
    private int classID;
    private String description;
    private double amount;

    public TransactionToCategory(int transaction_to_category_ID, int transactionID, int categoryID, int classID, String description, double amount) {
        this.transaction_to_category_ID = transaction_to_category_ID;
        this.transactionID = transactionID;
        this.categoryID = categoryID;
        this.classID = classID;
        this.description = description;
        this.amount = amount;
    }
}
