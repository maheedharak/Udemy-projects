package org.personal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;

    public DBConnection(String userName,String password,String url){
        try {
            connection = DriverManager.getConnection(url, userName, password);
        }catch(SQLException ex){
            System.out.println("exception while connecting is "+ex);
        }

    }

}
