package org.bank.data;

import org.bank.model.BankData;

import java.util.ArrayList;
import java.util.List;

public class BankDataStub {
    private static List<BankData> bankData;
    public void getAllBankData(){
        bankData = new ArrayList<>(){
            {
                new BankData("123456","1234567",
                        "Joe Bloggs",
                        "Athlone",
                        300.0);
                new BankData("111111",
                        "87654321",
                        "Ann Bloggs",
                        "Athlone",
                        500.0);
                new BankData("222222",
                        "67676767",
                        "Jane Doe",
                        "Dublin",
                        200.0);
            }
        };

    }
}
