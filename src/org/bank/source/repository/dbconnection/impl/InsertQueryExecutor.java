package org.bank.source.repository.dbconnection.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.repository.dbconnection.Executor;
import org.bank.source.service.params.ParamsSetter;
import org.bank.source.service.params.impl.InsertQueryParamsSetter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertQueryExecutor implements Executor {
    private static final ParamsSetter paramsSetter = new InsertQueryParamsSetter();
    @Override
    public ResultSet execute(QueryBuilderParams queryBuilderParams) {
        return null;
    }



    @Override
    public ResultSet executeWithParams(QueryBuilderParams queryBuilderParams) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        try(Connection conn = postgresDBConn.getDBConnection()){
            StringBuilder statementBuilder = paramsSetter.setParams(queryBuilderParams);
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
                System.out.println("SQLException is "+e);
            }
        }

        return rs;
    }
}
