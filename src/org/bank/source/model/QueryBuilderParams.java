package org.bank.source.model;

import java.sql.PreparedStatement;
import java.util.List;

public class QueryBuilderParams {
    private Object targetData;
    private PreparedStatement statement;

    public Object getTargetData() {
        return targetData;
    }

    public PreparedStatement getStatement() {
        return statement;
    }

    public List<String> getParamNames() {
        return paramNames;
    }

    public String getQuery() {
        return query;
    }

    public Object getSourceData() {
        return sourceData;
    }

    public String getTableName() {
        return tableName;
    }

    private List<String> paramNames;
    private String query;
    private Object sourceData;

    private String tableName;


   private QueryBuilderParams(Object targetData,PreparedStatement statement,List<String> paramNames,String query,Object sourceData,String tableName){
       this.targetData = targetData;
       this.statement = statement;
       this.paramNames = paramNames;
       this.query = query;
       this.sourceData = sourceData;
       this.tableName = tableName;
   }
   public static class QueryBuilderParamsBuilder {
       private Object targetData;
       private PreparedStatement statement;
       private List<String> paramNames;
       private String query;
       private Object sourceData;

       private String tableName;

       private QueryBuilderParamsBuilder queryBuilderParamsBuilder;

       public static QueryBuilderParamsBuilder newInstance(){
           return new QueryBuilderParamsBuilder();
       }
       public QueryBuilderParamsBuilder setTargetData(Object targetData){
           this.targetData = targetData;
           return this;
       }
       public QueryBuilderParamsBuilder setStatement(PreparedStatement statement){
           this.statement = statement;
           return this;
       }
       public QueryBuilderParamsBuilder setParamNames(List<String> paramNames){
           this.paramNames = paramNames;
           return this;
       }
       public QueryBuilderParamsBuilder setQuery(String query){
           this.query = query;
           return this;
       }
       public QueryBuilderParamsBuilder setSourceData(Object sourceData){
           this.sourceData = sourceData;
           return this;
       }
       public QueryBuilderParamsBuilder setTableName(String tableName){
           this.tableName = tableName;
           return this;
       }
       public QueryBuilderParams build(){
          return new QueryBuilderParams(this.targetData,this.statement,this.paramNames,this.query,this.sourceData,this.tableName);
       }
   }

}
