package org.bank.source.repository.dbconnection;

import org.bank.source.utility.PropertyLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public interface DatabaseConnection {
    PropertyLoader propertyLoader = PropertyLoader.getInstance();
    default Map<String,String> loadPostgresDetails(){
       return propertyLoader.loadPostgresProperties();
    }
    Connection getDBConnection();
   void closeConnection(Connection connection, ResultSet rs, PreparedStatement statement);
}
