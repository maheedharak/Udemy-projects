package org.bank.source.repository.dbconnection.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.repository.dbconnection.Executor;
import org.bank.source.service.params.ParamsSetter;
import org.bank.source.service.params.impl.UpdateQueryParamsSetter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateQueryExecutor implements Executor {
    private static final ParamsSetter parametersSetter = new UpdateQueryParamsSetter();
    @Override
    public ResultSet execute(QueryBuilderParams queryBuilderParams) {
       return null;
    }

    @Override
    public ResultSet executeWithParams(QueryBuilderParams queryBuilderParams) {
        ResultSet rs = null;
        try(Connection conn = postgresDBConn.getDBConnection()){
            StringBuilder updateQuery = parametersSetter.setParams(queryBuilderParams);
            PreparedStatement statement = conn.prepareStatement(updateQuery.toString());
            boolean isExecuted = statement.execute();
        }catch(SQLException ex){
            System.out.println("Exception while updating params is "+ex);
        }
        return rs;
    }
}
