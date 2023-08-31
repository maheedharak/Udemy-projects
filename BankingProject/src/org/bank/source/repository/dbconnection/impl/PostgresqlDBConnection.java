package org.bank.source.repository.dbconnection.impl;

import org.bank.source.model.Properties;
import org.bank.source.repository.dbconnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class PostgresqlDBConnection implements DatabaseConnection {
    private static Connection postgresConn;
    @Override
    public Connection getDBConnection() {
        try {
            Map<String, String> postgresDetails = loadPostgresDetails();
            if (postgresDetails != null) {
                String urlBuilder = new String(postgresDetails.get(Properties.URL.getProperty()));
                Properties[] postgresProperties = Properties.values();
                for (Properties property : postgresProperties) {
                    String propertyValue = postgresDetails.get(property.getProperty());
                    urlBuilder = urlBuilder.replace(property.getAlias(), propertyValue);
                }
                postgresConn = DriverManager.getConnection(urlBuilder);
                postgresConn.setSchema(postgresDetails.get(Properties.SCHEMANAME.getProperty()));
            }
        }catch(SQLException ex){
            System.out.println("Exception in getting connection is "+ex);
        }
        return postgresConn;
    }

    @Override
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        }catch(SQLException ex){
            System.out.println("Exception in closing connection is "+ex);
        }
    }

}
