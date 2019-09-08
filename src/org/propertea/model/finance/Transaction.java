package org.propertea.model.finance;

import java.util.Date;

public class Transaction {

    private int transactionID;
    private int transaction_to_category_ID;
    private int payeeID;
    private int userID;
    private int typeID;
    private Date transactionDate;
    private int checkNumber;
    private String memo;
    private double transactionTotal;
    private boolean isVoid;

    public Transaction(int transactionID, int transaction_to_category_ID, int payeeID, int userID, int typeID, Date transactionDate, int checkNumber, String memo, double transactionTotal, boolean isVoid) {
        this.transactionID = transactionID;
        this.transaction_to_category_ID = transaction_to_category_ID;
        this.payeeID = payeeID;
        this.userID = userID;
        this.typeID = typeID;
        this.transactionDate = transactionDate;
        this.checkNumber = checkNumber;
        this.memo = memo;
        this.transactionTotal = transactionTotal;
        this.isVoid = isVoid;
    }
}
