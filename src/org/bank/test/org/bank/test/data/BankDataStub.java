package org.bank.test.data;

import org.bank.source.model.BankData;

import java.util.ArrayList;
import java.util.List;

public class BankDataStub {

    public List<BankData> getAllBankData(){
       return new ArrayList<>(){
            {
                add(new BankData("123456","12345678",
                        "Joe Bloggs",
                        "Athlone",
                        300.0));
                add(new BankData("111111",
                        "87654321",
                        "Ann Bloggs",
                        "Athlone",
                        500.0));
                add(new BankData("222222",
                        "67676767",
                        "Jane Doe",
                        "Dublin",
                        200.0));
            }
        };

    }
}
