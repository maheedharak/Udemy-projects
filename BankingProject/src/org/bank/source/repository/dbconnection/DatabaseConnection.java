package org.bank.source.repository.dbconnection;

import org.bank.source.utility.PropertyLoader;

import java.sql.Connection;
import java.util.Map;

public interface DatabaseConnection {
    PropertyLoader propertyLoader = PropertyLoader.getInstance();
    default Map<String,String> loadPostgresDetails(){
       return propertyLoader.loadPostgresProperties();
    }
    Connection getDBConnection();
    void closeConnection(Connection connection);
}
