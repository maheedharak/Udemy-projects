package org.bank.source.repository.dbconnection.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.repository.dbconnection.Executor;
import org.bank.source.utility.ParametersSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertQueryExecutor implements Executor {
    private ParametersSetter paramsSetter;
    @Override
    public ResultSet execute(QueryBuilderParams queryBuilderParams) {
        return null;
    }

    @Override
    public ResultSet executeWithParams(String sql, Object data,Object sourceObject) {
        paramsSetter = new ParametersSetter();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try(Connection conn = postgresDBConn.getDBConnection()){
            StringBuilder statementBuilder = paramsSetter.setInsertParams(data,sql);
            statement = conn.prepareStatement(statementBuilder.toString());
            boolean isExecuted = statement.execute();
            if(isExecuted){
                rs = statement.getResultSet();
            }
        }catch(SQLException ex){
            System.out.println("SQLException while inserting is "+ex);
        }finally{
            try {
                if (statement != null) {
                    statement.close();
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return rs;
    }
}
