package org.bank.repository.dbconnection.impl;

import org.bank.repository.dbconnection.Executor;
import org.bank.utility.ParametersSetter;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteQueryExecutor implements Executor {
    private static final Connection conn = postgresDBConn.getDBConnection();
    private static final ParametersSetter paramsSetter = new ParametersSetter();
   @Override
    public ResultSet execute(String sql) {
       ResultSet rs = null;
       try {
           PreparedStatement statement = conn.prepareStatement(sql);
           boolean isExecuted = statement.execute();
           if (isExecuted) {
               rs = statement.getResultSet();
           }
       } catch (SQLException e) {
           System.out.println("Exception while deleting records is "+e);
       }

       return rs;
    }

    @Override
    public ResultSet executeWithParams(String sql, Object data) {
        ResultSet rs = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            String[] paramNames = paramsSetter.splitParams(sql);
            statement = paramsSetter.setParams(data,statement,paramNames);
            boolean isExecuted = statement.execute();
            if (isExecuted) {
                rs = statement.getResultSet();
            }
        } catch (SQLException e) {
            System.out.println("Exception while deleting records  with params is "+e);
        }
        return rs;
    }
}