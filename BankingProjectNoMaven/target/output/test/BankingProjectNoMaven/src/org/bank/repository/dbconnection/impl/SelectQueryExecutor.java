package org.bank.repository.dbconnection.impl;

import org.bank.repository.dbconnection.Executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectQueryExecutor implements Executor {
    ResultSet rs = null;
    @Override
    public ResultSet execute(String sql) {
        Connection conn = null;
        try {
           conn = postgresDBConn.getDBConnection();
            System.out.println(conn.getSchema());
           PreparedStatement statement = conn.prepareStatement(sql);
           boolean isExecuted = statement.execute();
           if(isExecuted){
               rs = statement.getResultSet();
           }
        }catch(SQLException ex){
            System.out.println("Exception while executing the insert is "+ex);
        }finally{
            if(conn != null){
                postgresDBConn.closeConnection(conn);
            }
        }
        return rs;
    }

    @Override
    public ResultSet executeWithParams(String sql, Object data) {
        return null;
    }
}
