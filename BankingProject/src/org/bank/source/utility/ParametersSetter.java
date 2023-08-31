package org.bank.source.utility;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.model.StopWords;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParametersSetter {

    public PreparedStatement setDeleteParams(QueryBuilderParams builderParams){
        List<String> paramNames = builderParams.getParamNames();
        Object data = builderParams.getTargetData();
        PreparedStatement statement = builderParams.getStatement();
        if(data != null && paramNames != null) {
            try {

                 Class fieldType;
                int paramsLen = paramNames.size();
                for (int i = 0; i < paramsLen; i++) {
                    Field field = data.getClass().getField(paramNames.get(i));
                    fieldType = field.getType();
                    if (field.get(data) != null) {
                        if (Integer.class.equals(fieldType)) {
                            statement.setInt((i + 1), field.getInt(data));
                        } else if (Double.class.equals(fieldType)) {
                            statement.setDouble((i + 1), field.getDouble(data));
                        } else if (String.class.equals(fieldType)) {
                            statement.setString((i + 1), field.get(data).toString());

                        } else {
                            throw new IllegalStateException("Unexpected value: " + fieldType);
                        }
                    }
                }
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccessException while setting params " + ex);
            } catch (SQLException e) {
                System.out.println("SQLException while setting params " + e);
            } catch (NoSuchFieldException e) {
                System.out.println("IllegalAccessException while setting params " + e);
            }
        }
        return statement;
    }
    public StringBuilder setInsertParams(Object data,String query){
        StringBuilder paramsBuilder = new StringBuilder(query);
        StringBuilder params = new StringBuilder();
        if(data != null){
            try {
                Field[] fieldArr = data.getClass().getDeclaredFields();
                int fieldArrLen = fieldArr.length;

                for (int i = 0; i < fieldArrLen; i++) {
                    if(i == 0){
                        paramsBuilder.append("(");
                    }
                    String fieldName = fieldArr[i].getName();
                    Class  fieldType  = fieldArr[i].getType();
                    if (fieldArr[i].get(data) != null) {
                        paramsBuilder.append("\"" + fieldName +"\"");
                        if (Integer.class.equals(fieldType)) {
                            params.append(fieldArr[i].getInt(data));
                        } else if (Double.class.equals(fieldType) || "double".equals(fieldType.toString())) {
                            params.append(fieldArr[i].getDouble(data));
                        } else if (String.class.equals(fieldType)) {
                            params.append("'"+fieldArr[i].get(data).toString()+"'");

                        } else {
                            throw new IllegalStateException("Unexpected value: " + fieldType);
                        }
                        paramsBuilder.append(",");
                        params.append(",");
                    }
                }
                String paramStr = paramsBuilder.substring(0,paramsBuilder.lastIndexOf(","));
                paramsBuilder = new StringBuilder(paramStr);
                paramsBuilder.append(") VALUES (");
                paramsBuilder.append(params.substring(0,params.lastIndexOf(",")));
                paramsBuilder.append(")");

            }catch (IllegalArgumentException e){
                System.out.println("IllegalArgumentException while setting params "+e);
            }catch(IllegalAccessException exception){
                System.out.println("IllegalAccessException while setting params "+exception);
            }
        }
        return paramsBuilder;
    }
    public StringBuilder setUpdateParams(Object data,String query,Object sourceObject){
        StringBuilder updateBuilder = new StringBuilder(query);
        StringBuilder whereBuilder = new StringBuilder(" where ");
        if(data != null) {
            Field[] fieldArr = data.getClass().getDeclaredFields();
            try {
                for (Field field : fieldArr) {
                    Class fieldType = field.getType();
                    if (field.get(data) != null) {
                        updateBuilder.append("\"" + field.getName() + "\"");
                        updateBuilder.append("=");
                        if (Integer.class.equals(fieldType)) {
                            updateBuilder.append(field.getInt(data));
                        } else if (Double.class.equals(fieldType) || "double".equals(fieldType.toString())) {
                            updateBuilder.append(field.getDouble(data));
                        } else if (String.class.equals(fieldType)) {
                            updateBuilder.append("'" + field.get(data).toString() + "'");

                        } else {
                            throw new IllegalStateException("Unexpected value: " + fieldType);
                        }
                    }
                    updateBuilder.append(",");
                }
                if (sourceObject != null) {
                    Field[] sourceFields = sourceObject.getClass().getDeclaredFields();
                    for (Field srcField : sourceFields) {
                        Class fieldType = srcField.getType();
                        if (srcField.get(sourceObject) != null) {
                            whereBuilder.append("\"" + srcField.getName() + "\"");
                            whereBuilder.append("=");
                            if (Integer.class.equals(fieldType)) {
                                whereBuilder.append(srcField.getInt(sourceObject));
                            } else if (Double.class.equals(fieldType) || "double".equals(fieldType.toString())) {
                                whereBuilder.append(srcField.getDouble(sourceObject));
                            } else if (String.class.equals(fieldType)) {
                                whereBuilder.append("'" + srcField.get(sourceObject).toString() + "'");

                            } else {
                                throw new IllegalStateException("Unexpected value: " + fieldType);
                            }
                        }
                        whereBuilder.append(" and ");
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            String updateStr = updateBuilder.substring(0, updateBuilder.lastIndexOf(","));
            updateBuilder = new StringBuilder(updateStr);
            updateBuilder.append(whereBuilder.substring(0,whereBuilder.lastIndexOf(" and ")));
        }
            return updateBuilder;
    }
    public List<String> splitParams(String query){
        int whereIndex = query.toLowerCase().indexOf("where");
        if(whereIndex != -1) {
            query = query.substring(whereIndex);
            for (StopWords words : StopWords.values()) {
                query = query.replace(words.getStopWord(), "");
            }
            List<String> params = Arrays.stream(query.split("=?\\?")).map(x -> x.trim().replace("\"", "")).collect(Collectors.toList());
            return params;
        }
        return null;
    }
}
