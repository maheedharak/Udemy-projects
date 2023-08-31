package org.bank.source.utility;

import java.util.*;

import org.bank.source.model.Properties;

public class PropertyLoader {
    private volatile static PropertyLoader propertyLoader;
    private static Map<String,String> properties;
    public static ResourceBundle bundle;
    private PropertyLoader(){
        bundle = ResourceBundle.getBundle("org.bank.source.utility.DBDetails", Locale.getDefault());
    }
    public static PropertyLoader getInstance(){
        if (propertyLoader == null) {
        synchronized (PropertyLoader.class) {
                propertyLoader = new PropertyLoader();
            }
        }
        return propertyLoader;
    }
    public Map<String,String> loadPostgresProperties(){
        properties = new HashMap<>();
        properties.put(Properties.URL.getProperty(),bundle.getString(Properties.URL.getProperty()));
        properties.put(Properties.USERNAME.getProperty(),bundle.getString(Properties.USERNAME.getProperty()));
        properties.put(Properties.PASSWORD.getProperty(),bundle.getString(Properties.PASSWORD.getProperty()));
        properties.put(Properties.PORT.getProperty(),bundle.getString(Properties.PORT.getProperty()));
        properties.put(Properties.DATABASE.getProperty(),bundle.getString(Properties.DATABASE.getProperty()));
        properties.put(Properties.SCHEMANAME.getProperty(),bundle.getString(Properties.SCHEMANAME.getProperty()));
        return properties;
    }
}
