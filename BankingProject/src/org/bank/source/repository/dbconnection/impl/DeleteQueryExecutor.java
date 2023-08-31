package org.bank.source.repository.dbconnection.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.repository.dbconnection.Executor;
import org.bank.source.utility.ParametersSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DeleteQueryExecutor implements Executor {

    private static final ParametersSetter paramsSetter = new ParametersSetter();
   @Override
    public ResultSet execute(QueryBuilderParams queryBuilderParams) {
       ResultSet rs = null;
       try(Connection conn = postgresDBConn.getDBConnection()) {
           PreparedStatement statement = conn.prepareStatement(queryBuilderParams.getQuery());
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
    public ResultSet executeWithParams(QueryBuilderParams queryBuilderParams) {
        ResultSet rs = null;
        try(Connection conn = postgresDBConn.getDBConnection()) {
            String sql = queryBuilderParams.getQuery();
            sql = sql.replace("<TABLE_NAME>","\""+queryBuilderParams.getTableName()+"\"");
            PreparedStatement statement = conn.prepareStatement(sql);
            List<String> paramNames = paramsSetter.splitParams(sql);
            queryBuilderParams = QueryBuilderParams.QueryBuilderParamsBuilder.newInstance()
                        .setQuery(queryBuilderParams.getQuery())
                        .setStatement(statement)
                        .setParamNames(paramNames).build();
            statement = paramsSetter.setDeleteParams(queryBuilderParams);
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