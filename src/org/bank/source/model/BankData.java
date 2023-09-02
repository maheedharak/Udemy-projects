package org.bank.source.model;

public class BankData {
    public String BRANCH_CODE;
    public String ACCOUNT_NUMBER;
    public String CUST_NAME;
    public String CUST_ADDRESS;
    public Double BALANCE;

    public String getBranchCode() {
        return BRANCH_CODE;
    }

    public String getAccountNumber() {
        return ACCOUNT_NUMBER;
    }

    public String getCustName() {
        return CUST_NAME;
    }

    @Override
    public String toString() {
        return "BankData{" +
                "branchCode='" + BRANCH_CODE + '\'' +
                ", accountNumber='" + ACCOUNT_NUMBER + '\'' +
                ", custName='" + CUST_NAME + '\'' +
                ", custAddress='" + CUST_ADDRESS + '\'' +
                ", balance=" + BALANCE +
                '}';
    }

    public String getCustAddress() {
        return CUST_ADDRESS;
    }

    public Double getBalance() {
        return BALANCE;
    }

    public BankData(String BRANCH_CODE, String ACCOUNT_NUMBER, String CUST_NAME, String CUST_ADDRESS, Double BALANCE){
        this.BRANCH_CODE = BRANCH_CODE;
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        this.CUST_NAME = CUST_NAME;
        this.CUST_ADDRESS = CUST_ADDRESS;
        this.BALANCE = BALANCE;
    }
    @Override
    public boolean equals(Object obj){
        if(obj != null){
            if(obj.getClass().equals(this.getClass())){
                BankData bankObj = (BankData)obj;
                return ((bankObj.ACCOUNT_NUMBER.equals(this.ACCOUNT_NUMBER)) &&
                        (bankObj.getBranchCode().equals(this.BRANCH_CODE)));
            }
        }
        return false;
    }
}
