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
         BankData bankData;
        try( ResultSet rs = component.setExecutor(new SelectQueryExecutor())
                    .execute(queryParams)) {

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
        BankData bankData;
        try(ResultSet rs = component.setExecutor(new DeleteQueryExecutor())
                    .executeWithParams(queryBuilderParams)) {

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
    public List<BankData> insertData(QueryBuilderParams queryBuilderParams) {
        bankDataLst = new ArrayList<>();
        BankData bankData;
        try(ResultSet rs = component.setExecutor(new InsertQueryExecutor())
                .executeWithParams(queryBuilderParams)) {
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
    public List<BankData> updateData(QueryBuilderParams builderParams) {
        bankDataLst = new ArrayList<>();
        BankData bankData;
        try(ResultSet rs = component.setExecutor(new UpdateQueryExecutor())
                .executeWithParams(builderParams)) {
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
