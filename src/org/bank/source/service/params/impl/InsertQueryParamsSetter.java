package org.bank.source.service.params.impl;

import org.bank.source.model.QueryBuilderParams;
import org.bank.source.service.params.ParamsSetter;

import java.lang.reflect.Field;

public class InsertQueryParamsSetter implements ParamsSetter {
    @Override
    public StringBuilder setParams(QueryBuilderParams queryBuilderParams) {
        String executableQuery = queryBuilderParams.getQuery();
        executableQuery = executableQuery.replace("<TABLE_NAME>","\""+queryBuilderParams.getTableName()+"\"");
        StringBuilder paramsBuilder = new StringBuilder(executableQuery);
        StringBuilder params = new StringBuilder();
        Object data = queryBuilderParams.getTargetData();
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
                    String value = fieldArr[i].get(data)!=null ? fieldArr[i].get(data).toString() : null;
                    if (value != null) {
                        paramsBuilder.append("\"" + fieldName +"\"");
                        if (Integer.class.equals(fieldType)) {
                            params.append(Integer.valueOf(value));
                        } else if (Double.class.equals(fieldType) || "double".equals(fieldType.toString())) {
                            params.append(Double.valueOf(value));
                        } else if (String.class.equals(fieldType)) {
                            params.append("'"+value+"'");
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
}
