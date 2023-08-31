package org.bank.source.repository.dbconnection.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.repository.dbconnection.Executor;
import org.bank.source.utility.ParametersSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateQueryExecutor implements Executor {
    ParametersSetter parametersSetter = new ParametersSetter();
    @Override
    public ResultSet execute(QueryBuilderParams queryBuilderParams) {
        return null;
    }

    @Override
    public ResultSet executeWithParams(String sql, Object data,Object sourceObject) {
        ResultSet rs = null;
        try(Connection conn = postgresDBConn.getDBConnection();){
            PreparedStatement statement = conn.prepareStatement(parametersSetter.setUpdateParams(data,sql,sourceObject).toString());
            boolean isExecuted = statement.execute();
        }catch(SQLException ex){
            System.out.println("Exception while updating params is "+ex);
        }
        return rs;
    }
}
