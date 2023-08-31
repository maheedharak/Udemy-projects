package org.bank.source.service;

import org.bank.source.model.BankData;
import org.bank.source.model.QueryBuilderParams;

import java.util.List;

public interface CallerInterface {
    List<BankData> getData(QueryBuilderParams queryParams);

    List<BankData> deleteData(QueryBuilderParams queryBuilderParams);

    List<BankData> insertData(String executableQuery, String tableName, Object data);

     List<BankData> updateData(String executableQuery, String tableName, Object data, Object sourceData);
}
