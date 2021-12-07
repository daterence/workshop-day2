package workshop.day2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BankAccount {

    private String name; //account holder's name
    private String accountNumber; //randomly generated account number
    private float accountBalance; //account balance in float
    private List<String> transactions; //transactions for operations performed on the account
    private boolean isClosed = false; //default as account is not closed
    private String createDate;
    private String closedDate;

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
        if(this.isClosed){
            closedDate = createTimeStamp();
        } else{
            closedDate = null;
        }
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    //create time stamp
    private String createTimeStamp(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE. d MMM yyyy HH:mm:ss Z");
        return simpleDateFormat.format(new Date());
    }
    // first constructor
    public BankAccount(String name) {
        this.name = name;
        this.accountBalance = 0f;
        String numericString = "0123456789";
        String accNumber = "";
        for (int i=0; i<10; i++){
            String element = String.valueOf((int)(numericString.length()*Math.random()));
            accNumber = accNumber.concat(element);
        }
        this.accountNumber = accNumber;
        transactions = new ArrayList<>();
        createDate = createTimeStamp();
    }
    // second constructor
    public BankAccount(String name, float accountBalance){
        this.name = name;
        this.accountBalance = accountBalance;
        transactions = new ArrayList<>();
        createDate = createTimeStamp();
    }

    // deposit method
    public void deposit(float amount){
        boolean isNegativeAmount = 0.0 - amount > 0.001;
        if(isNegativeAmount == true || isClosed){
            throw new IllegalArgumentException("Enter a positive value");
        }
        String transaction = "deposit $" + amount + " at " + createTimeStamp();
        transactions.add(transaction);
        this.accountBalance += amount;
    }

    // withdraw method
    public void withdraw(float amount){
        boolean isNegativeAmount = 0.0 - amount > 0.001;
        if(isNegativeAmount == true || amount > this.accountBalance || isClosed){
            throw new IllegalArgumentException("Enter a positive value");
        }
        String transaction =  "withdraw $" + amount + " at " + createTimeStamp();
        transactions.add(transaction);
        this.accountBalance -= amount;
    }
}
