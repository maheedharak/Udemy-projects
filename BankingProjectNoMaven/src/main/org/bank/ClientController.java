package org.bank;

import org.bank.model.BankData;
import org.bank.model.Queries;
import org.bank.model.TABLES;
import org.bank.service.CallerInterface;
import org.bank.service.impl.BankDataImpl;

import java.util.List;

public class ClientController {
   static CallerInterface callerInterface = new BankDataImpl();;

    public static void main(String[] args){
        getBankData();
        getAllBankData();
        deleteDataByAccountName();
        getAllBankData();
    }
    public static void getBankData(){
       List<BankData> bankDataLst =  callerInterface.getData( Queries.SELECT_1_QUERY,TABLES.BANK_TABLE.toString());
        bankDataLst.stream().map(BankData::toString).forEach(System.out::println);
    }
    public static void getAllBankData(){
        List<BankData> bankDataLst =  callerInterface.getData( Queries.DELETE_1_QUERY,TABLES.BANK_TABLE.toString());
        bankDataLst.stream().map(BankData::toString).forEach(System.out::println);
    }
    public static void deleteDataByAccountName(){
        BankData bankData = new BankData("123456","12345678",null,null,0d);
         callerInterface.deleteData( Queries.DELETE_1_QUERY,TABLES.BANK_TABLE.toString(),bankData);
    }
}
