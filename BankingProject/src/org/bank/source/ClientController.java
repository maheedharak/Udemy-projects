package org.bank.source;

import org.bank.source.model.BankData;
import org.bank.source.model.Queries;
import org.bank.source.model.QueryBuilderParams;
import org.bank.source.model.TABLES;
import org.bank.source.service.CallerInterface;
import org.bank.source.service.impl.BankDataImpl;

import java.util.List;

public class ClientController {
   static CallerInterface callerInterface = new BankDataImpl();;


    public static List<BankData> getBankData(){
        QueryBuilderParams builderParam = QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                .setQuery(Queries.SELECT_1_QUERY)
                .setTableName(TABLES.BANK_TABLE.toString()).build();
       List<BankData> bankDataLst =  callerInterface.getData(builderParam);
       return bankDataLst;
    }
    public static List<BankData> getAllBankData(){
        QueryBuilderParams builderParam = QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                                                                    .setQuery(Queries.SELECT_ALL_QUERY)
                                                                    .setTableName(TABLES.BANK_TABLE.toString()).build();
        List<BankData> bankDataLst =  callerInterface.getData(builderParam);
        return bankDataLst;
    }
    public static List<BankData> deleteDataByAccountName(BankData bankData,List<String> conditions){
        StringBuilder deleteQuery = new StringBuilder(Queries.DELETE_1_QUERY);
        deleteQuery.append(" where ");
        for(String condition: conditions) {
            deleteQuery.append("  \""+condition+"\"=?");
            deleteQuery.append(" and ");
        }
        String deleteQueryStr = deleteQuery.substring(0,deleteQuery.lastIndexOf(" and "));
        QueryBuilderParams builderParam = QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                                                            .setQuery(deleteQueryStr)
                                                            .setTableName(TABLES.BANK_TABLE.toString())
                                                            .setTargetData(bankData)
                                                            .build();

        List<BankData> bankDataLst =  callerInterface.deleteData(builderParam);
        return bankDataLst;
    }

    public static List<BankData> insertBankData(BankData bankData){
        return callerInterface.insertData(Queries.INSERT_QUERY,TABLES.BANK_TABLE.toString(),bankData);
    }
  /*  public static List<BankData> updateBankData(){

        return callerInterface.updateData(Queries.UPDATE_QUERY,TABLES.BANK_TABLE.toString(),bankData,sourceBankData);
    }*/
}
