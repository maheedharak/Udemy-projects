package org.bank.service;

import org.bank.model.BankData;

import java.util.List;

public interface CallerInterface {
    List<BankData> getData(String executableQuery, String tableName);

    void deleteData(String executableQuery, String tableName,Object data);
}
