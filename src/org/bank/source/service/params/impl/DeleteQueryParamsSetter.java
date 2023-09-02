package org.bank.source.service.params.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.service.params.ParamsSetter;

import java.lang.reflect.Field;

public class DeleteQueryParamsSetter implements ParamsSetter {
    @Override
    public StringBuilder setParams(QueryBuilderParams queryBuilderParams) {
        String sql = queryBuilderParams.getQuery();
        sql = sql.replace("<TABLE_NAME>","\""+queryBuilderParams.getTableName()+"\"");
        StringBuilder fieldBuilder = null;
        Object data = queryBuilderParams.getTargetData();
        if(data != null) {
            fieldBuilder = new StringBuilder(sql);
            fieldBuilder.append("WHERE ");
            Field[] declaredFields = data.getClass().getDeclaredFields();
            try {
                for (Field field: declaredFields) {
                    Class fieldType = field.getType();
                    String fieldName = field.getName();
                    String obj = field.get(data)!= null?field.get(data).toString():null;
                    if (obj != null) {
                        if (Integer.class.equals(fieldType) || "int".equals(fieldType.toString())) {
                            fieldBuilder.append("\"").append(fieldName).append("\" = ");
                            fieldBuilder.append(Integer.valueOf(obj));
                        } else if (Double.class.equals(fieldType) || ("double".equals(fieldType.toString()) )) {
                            fieldBuilder.append("\""+fieldName+"\" = ");
                            fieldBuilder.append(Double.valueOf(obj));
                        } else if (String.class.equals(fieldType)) {
                            fieldBuilder.append("\""+fieldName+"\" = ");
                            fieldBuilder.append("'"+obj+"'");

                        } else {
                            throw new IllegalStateException("Unexpected value: " + fieldType);
                        }
                        fieldBuilder.append(" AND ");
                    }
                }
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccessException while setting params " + ex);
            }
        }
        return fieldBuilder != null ? (new StringBuilder(fieldBuilder.substring(0,fieldBuilder.lastIndexOf(" AND ")))) : null;
    }
}
