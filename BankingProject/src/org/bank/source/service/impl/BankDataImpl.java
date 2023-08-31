package org.bank.source.service.impl;

import org.bank.source.model.BankData;
import org.bank.source.model.QueryBuilderParams;
import org.bank.source.repository.dbconnection.Component;
import org.bank.source.repository.dbconnection.impl.DeleteQueryExecutor;
import org.bank.source.repository.dbconnection.impl.InsertQueryExecutor;
import org.bank.source.repository.dbconnection.impl.SelectQueryExecutor;
import org.bank.source.repository.dbconnection.impl.UpdateQueryExecutor;
import org.bank.source.service.CallerInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankDataImpl implements CallerInterface {
    private static final Component component = new Component();

    private List<BankData> bankDataLst;

    @Override
    public List<BankData> getData(QueryBuilderParams queryParams) {
        bankDataLst = new ArrayList<>();
        ResultSet rs = component.setExecutor(new SelectQueryExecutor())
                                .execute(queryParams);
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
    public List<BankData> deleteData(QueryBuilderParams queryBuilderParams) {
        bankDataLst = new ArrayList<>();
        ResultSet rs = component.setExecutor(new DeleteQueryExecutor())
                .executeWithParams(queryBuilderParams);
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
    public List<BankData> insertData(String executableQuery, String tableName, Object data) {
        bankDataLst = new ArrayList<>();
        executableQuery = executableQuery.replace("<TABLE_NAME>","\""+tableName+"\"");
        ResultSet rs = component.setExecutor(new InsertQueryExecutor())
                .executeWithParams(executableQuery,data,null);
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
    public List<BankData> updateData(String executableQuery, String tableName, Object data, Object sourceData) {
        bankDataLst = new ArrayList<>();
        executableQuery = executableQuery.replace("<TABLE_NAME>","\""+tableName+"\"");
        ResultSet rs = component.setExecutor(new UpdateQueryExecutor())
                .executeWithParams(executableQuery,data,sourceData);
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
}
