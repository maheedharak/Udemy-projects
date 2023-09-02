package org.bank.source.repository.dbconnection.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.repository.dbconnection.Executor;
import org.bank.source.service.params.ParamsSetter;
import org.bank.source.service.params.impl.DeleteQueryParamsSetter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DeleteQueryExecutor implements Executor {

    private static final ParamsSetter paramsSetter = new DeleteQueryParamsSetter();

    @Override
    public ResultSet execute(QueryBuilderParams queryBuilderParams) {
        ResultSet rs = null;
        try (Connection conn = postgresDBConn.getDBConnection()) {
            PreparedStatement statement = conn.prepareStatement(queryBuilderParams.getQuery());
            boolean isExecuted = statement.execute();
            if (isExecuted) {
                rs = statement.getResultSet();
            }
        } catch (SQLException e) {
            System.out.println("Exception while deleting records is " + e);
        }

        return rs;
    }


    @Override
    public ResultSet executeWithParams(QueryBuilderParams queryBuilderParams) {
        ResultSet rs = null;
        StringBuilder query = paramsSetter.setParams(queryBuilderParams);
        try (Connection conn = postgresDBConn.getDBConnection()) {
            PreparedStatement statement = conn.prepareStatement(query.toString());
            boolean isExecuted = statement.execute();
            if (isExecuted) {
                rs = statement.getResultSet();
            }
        } catch (SQLException e) {
            System.out.println("Exception while deleting records  with params is " + e);
        }
        return rs;
    }
}