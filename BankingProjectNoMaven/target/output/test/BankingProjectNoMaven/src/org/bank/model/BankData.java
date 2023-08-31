package org.bank.model;

public class BankData {
    private String branchCode;
    private String accountNumber;
    private String custName;
    private String custAddress;
    private double balance;

    public String getBranchCode() {
        return branchCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustName() {
        return custName;
    }

    @Override
    public String toString() {
        return "BankData{" +
                "branchCode='" + branchCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getCustAddress() {
        return custAddress;
    }

    public double getBalance() {
        return balance;
    }

    public BankData(String branchCode, String accountNumber, String custName, String custAddress, double balance){
        this.branchCode = branchCode;
        this.accountNumber = accountNumber;
        this.custName = custName;
        this.custAddress = custAddress;
        this.balance = balance;
    }
}
