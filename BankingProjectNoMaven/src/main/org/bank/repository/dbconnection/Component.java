package org.bank.repository.dbconnection;

import java.sql.ResultSet;

public class Component {
    private Executor executor;

    public Executor setExecutor(Executor executor){
        this.executor = executor;
        return this.executor;
    }

    public ResultSet execute(String sql,String... params){
        return this.executor.execute(sql);
    }
}
