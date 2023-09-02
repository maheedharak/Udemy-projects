package org.bank.source;

import org.bank.source.model.BankData;
import org.bank.source.model.Queries;
import org.bank.source.model.QueryBuilderParams;
import org.bank.source.model.TABLES;
import org.bank.source.service.CallerInterface;
import org.bank.source.service.impl.BankDataImpl;

import java.util.List;

public class ClientController {
   static CallerInterface callerInterface = new BankDataImpl();


    public static List<BankData> getBankData(){
        QueryBuilderParams builderParam = QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                .setQuery(Queries.SELECT_1_QUERY)
                .setTableName(TABLES.BANK_TABLE.toString()).build();
        return callerInterface.getData(builderParam);
    }
    public static List<BankData> getAllBankData(){
        QueryBuilderParams builderParam = QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                                                                    .setQuery(Queries.SELECT_ALL_QUERY)
                                                                    .setTableName(TABLES.BANK_TABLE.toString()).build();
        return callerInterface.getData(builderParam);
    }
    public static List<BankData> deleteDataByAccountName(BankData bankData){
        QueryBuilderParams builderParam = QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                                                            .setQuery(Queries.DELETE_1_QUERY)
                                                            .setTableName(TABLES.BANK_TABLE.toString())
                                                            .setTargetData(bankData)
                                                            .build();


        return callerInterface.deleteData(builderParam);
    }

    public static List<BankData> insertBankData(BankData bankData){
        QueryBuilderParams builderParam = QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                .setQuery(Queries.INSERT_QUERY)
                .setTableName(TABLES.BANK_TABLE.toString())
                .setTargetData(bankData)
                .build();
        return callerInterface.insertData(builderParam);
    }
        public static List<BankData> updateBankData(BankData sourceData,BankData targetData){
            QueryBuilderParams builderParam = QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                    .setQuery(Queries.UPDATE_QUERY)
                    .setTableName(TABLES.BANK_TABLE.toString())
                    .setTargetData(targetData)
                    .setSourceData(sourceData)
                    .build();
        return callerInterface.updateData(builderParam);
    }
}
