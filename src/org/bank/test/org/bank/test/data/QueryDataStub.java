package org.bank.test.data;

import org.bank.source.model.BankData;
import org.bank.source.model.Queries;
import org.bank.source.model.QueryBuilderParams;
import org.bank.source.model.TABLES;


import java.util.List;

public class QueryDataStub {
    public static BankDataStub bankData;

    public  static List<BankData> sourceData;

    public static void setup(){
        bankData = new BankDataStub();
        sourceData = bankData.getAllBankData();
    }

    public static QueryBuilderParams insertQueryData(){
        BankData bankData = new BankData("999999",
                "99999999","M Kameswari",
                "Wroclaw",690.0d);
        return QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                .setQuery(Queries.INSERT_QUERY)
                .setTableName(TABLES.BANK_TABLE.toString())
                .setTargetData(bankData).build();
    }
    public static QueryBuilderParams updateQueryData(){
        setup();
        BankData sampleData = sourceData.get(0);
        BankData newData = new BankData(null,
                null,
                null,
                "Poland",
                0.0);
        return QueryBuilderParams.QueryBuilderParamsBuilder
                .newInstance()
                .setQuery(Queries.UPDATE_QUERY)
                .setTableName(TABLES.BANK_TABLE.toString())
                .setSourceData(sampleData)
                .setTargetData(newData).build();
    }
    public static QueryBuilderParams deleteQueryData(){
        BankData newData = new BankData("123456",
                "12345678",
                null,
                null,
                null);
        return QueryBuilderParams.QueryBuilderParamsBuilder
                .newInstance()
                .setQuery(Queries.DELETE_1_QUERY)
                .setTableName(TABLES.BANK_TABLE.toString())
                .setTargetData(newData)
                .build();
    }
    public static QueryBuilderParams selectQueryData(){
        BankData newData = new BankData("123456",
                "12345678",
                null,
                null,
                null);
        return QueryBuilderParams.QueryBuilderParamsBuilder
                .newInstance()
                .setQuery(Queries.SELECT_ALL_QUERY)
                .setTableName(TABLES.BANK_TABLE.toString())
                .setTargetData(newData)
                .build();
    }
}
