package org.bank.service.impl;

import org.bank.model.BankData;
import org.bank.repository.dbconnection.Component;
import org.bank.repository.dbconnection.impl.DeleteQueryExecutor;
import org.bank.repository.dbconnection.impl.SelectQueryExecutor;
import org.bank.service.CallerInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankDataImpl implements CallerInterface {
    private static final Component component = new Component();

    private List<BankData> bankDataLst;

    @Override
    public List<BankData> getData(String executableQuery, String tableName) {
        bankDataLst = new ArrayList<>();
        executableQuery = executableQuery.replace("<TABLE_NAME>","\""+tableName+"\"");
        ResultSet rs = component.setExecutor(new SelectQueryExecutor())
                                .execute(executableQuery);
        BankData bankData = null;
        try {
            if (rs != null) {
                    while(rs.next()) {
                        bankData = new BankData(rs.getString(1)
                                , rs.getString(2),
                                rs.getString(3), rs.getString(4), rs.getDouble(5));
                        bankDataLst.add(bankData);
                    }
            }
        }catch (SQLException ex){
            System.out.println("Exception in resultset is "+ex);
        }
        return bankDataLst;
    }

    @Override
    public void deleteData(String executableQuery, String tableName,Object data) {

        bankDataLst = new ArrayList<>();
        executableQuery = executableQuery.replace("<TABLE_NAME>","\""+tableName+"\"");
        ResultSet rs = component.setExecutor(new DeleteQueryExecutor())
                .executeWithParams(executableQuery,data);
        BankData bankData = null;
        try {
            if (rs != null) {
                while(rs.next()) {
                    bankData = new BankData(rs.getString(1)
                            , rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getDouble(5));
                    bankDataLst.add(bankData);
                }
            }
        }catch (SQLException ex){
            System.out.println("Exception in resultset is "+ex);
        }
    }
}
