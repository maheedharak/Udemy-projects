package org.bank.source.repository.dbconnection;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.repository.dbconnection.impl.PostgresqlDBConnection;

import java.sql.ResultSet;

public interface Executor {
    DatabaseConnection postgresDBConn = new PostgresqlDBConnection();

    ResultSet execute(QueryBuilderParams queryBuilderParams);

    ResultSet executeWithParams(String sql, Object data,Object sourceObject);

    public ResultSet executeWithParams(QueryBuilderParams queryBuilderParams);
}
