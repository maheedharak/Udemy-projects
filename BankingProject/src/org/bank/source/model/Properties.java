package org.bank.source.model;

public enum Properties {
    USERNAME("username","<username>"),
    PASSWORD("password","<password>"),
    URL("url","<url>"),
    PORT("port","<port>"),
    SCHEMANAME("schema","<schema>"),
    DATABASE("database","<database>");

    private String property;

    private String alias;
    Properties(String property,String alias){
        this.property = property;
        this.alias = alias;
    }
    public String getProperty(){
        return this.property;
    }
    public String getAlias(){
        return this.alias;
    }

}
