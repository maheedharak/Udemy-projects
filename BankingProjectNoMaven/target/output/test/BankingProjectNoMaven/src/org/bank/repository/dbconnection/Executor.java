package org.bank.repository.dbconnection;

import org.bank.repository.dbconnection.impl.PostgresqlDBConnection;

import java.sql.ResultSet;

public interface Executor {
    DatabaseConnection postgresDBConn = new PostgresqlDBConnection();

    ResultSet execute(String sql);

    ResultSet executeWithParams(String sql, Object data);
}
