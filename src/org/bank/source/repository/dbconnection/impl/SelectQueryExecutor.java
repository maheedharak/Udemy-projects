package org.bank.source.repository.dbconnection.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.repository.dbconnection.Executor;
import org.bank.source.service.params.ParamsSetter;
import org.bank.source.service.params.impl.InsertQueryParamsSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectQueryExecutor implements Executor {


    private static final ParamsSetter selectParamsSetter = new InsertQueryParamsSetter();

    @Override
    public ResultSet execute(QueryBuilderParams queryBuilderParams) {
        String executableQuery = queryBuilderParams.getQuery();
        String tableName = queryBuilderParams.getTableName();
        ResultSet rs = null;
        if (executableQuery != null && tableName != null) {
            executableQuery = executableQuery.replace("<TABLE_NAME>", "\"" + tableName + "\"");
            try (Connection conn = postgresDBConn.getDBConnection();

            ) {
                PreparedStatement statement = conn.prepareStatement(executableQuery);
                boolean isExecuted = statement.execute();
                if (isExecuted) {
                    rs = statement.getResultSet();
                }

            } catch (SQLException e) {
               System.out.println("Exception while getting data is "+e);
            }
        }
        return rs;
    }


    @Override
    public ResultSet executeWithParams(QueryBuilderParams queryBuilderParams) {
        ResultSet rs = null;
        try (Connection conn = postgresDBConn.getDBConnection()) {
            // String executableQuery = queryBuilderParams.getQuery();
            //String tableName = queryBuilderParams.getTableName();
            //if (executableQuery != null && tableName != null) {
            //  executableQuery = executableQuery.replace("<TABLE_NAME>", "\"" + tableName + "\"");
            StringBuilder queryBuilder = selectParamsSetter.setParams(queryBuilderParams);
            PreparedStatement statement = conn.prepareStatement(queryBuilder.toString());
            boolean isExecuted = statement.execute();
            if (isExecuted) {
                rs = statement.getResultSet();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
