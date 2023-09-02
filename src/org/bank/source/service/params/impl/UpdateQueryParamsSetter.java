package org.bank.source.service.params.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.service.params.ParamsSetter;

import java.lang.reflect.Field;

public class UpdateQueryParamsSetter implements ParamsSetter {
    @Override
    public StringBuilder setParams(QueryBuilderParams queryBuilderParams) {
        String executableQuery = queryBuilderParams.getQuery();
        executableQuery = executableQuery.replace("<TABLE_NAME>","\""+queryBuilderParams.getTableName()+"\"");
        StringBuilder updateBuilder = new StringBuilder(executableQuery);
        StringBuilder whereBuilder = new StringBuilder(" where ");
        Object data = queryBuilderParams.getTargetData();
        Object sourceObject = queryBuilderParams.getSourceData();
        if(data != null) {
            Field[] fieldArr = data.getClass().getDeclaredFields();
            try {
                for (Field field : fieldArr) {
                    Class fieldType = field.getType();
                    String value = field.get(data) != null?field.get(data).toString():null;
                    if (value != null) {
                        updateBuilder.append("\"").append(field.getName()).append("\"");
                        updateBuilder.append(" = ");
                        if (Integer.class.equals(fieldType)) {
                            updateBuilder.append(Integer.valueOf(value));
                        } else if (Double.class.equals(fieldType) || "double".equals(fieldType.toString())) {
                            updateBuilder.append(Double.valueOf(value));
                        } else if (String.class.equals(fieldType)) {
                            updateBuilder.append("'" + value + "'");

                        } else {
                            throw new IllegalStateException("Unexpected value: " + fieldType);
                        }
                        updateBuilder.append(",");
                    }

                }
                if (sourceObject != null) {
                    Field[] sourceFields = sourceObject.getClass().getDeclaredFields();
                    for (Field srcField : sourceFields) {
                        Class fieldType = srcField.getType();
                        if (srcField.get(sourceObject) != null) {
                            whereBuilder.append("\"")
                                    .append(srcField.getName())
                                    .append("\"");
                            whereBuilder.append(" = ");
                            String srcVal = srcField.get(sourceObject) != null ? srcField.get(sourceObject).toString() : null;
                           if(srcVal != null) {
                               if (Integer.class.equals(fieldType)) {
                                   whereBuilder.append(Integer.valueOf(srcVal));
                               } else if (Double.class.equals(fieldType) || "double".equals(fieldType.toString())) {
                                   whereBuilder.append(Double.valueOf(srcVal));
                               } else if (String.class.equals(fieldType)) {
                                   whereBuilder.append("'")
                                           .append(srcVal)
                                           .append("'");

                               } else {
                                   throw new IllegalStateException("Unexpected value: " + fieldType);
                               }
                           }
                        }
                        whereBuilder.append(" AND ");
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            String updateStr = updateBuilder.substring(0, updateBuilder.lastIndexOf(","));
            updateBuilder = new StringBuilder(updateStr);
            updateBuilder.append(whereBuilder.substring(0,whereBuilder.lastIndexOf(" AND ")));
        }
        return updateBuilder;
    }
}
