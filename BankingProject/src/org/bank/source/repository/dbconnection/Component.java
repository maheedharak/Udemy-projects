package org.bank.source.repository.dbconnection;

import org.bank.source.model.QueryBuilderParams;

import java.sql.ResultSet;

public class Component {
    private Executor executor;

    public Executor setExecutor(Executor executor){
        this.executor = executor;
        return this.executor;
    }

    public ResultSet execute(QueryBuilderParams queryBuilderParams){
        return this.executor.execute(queryBuilderParams);
    }
}
