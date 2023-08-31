package org.bank.utility;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class ParametersSetter {

    public PreparedStatement setParams(Object data,PreparedStatement statement,String[] paramNames){
        try {
            Field[] fieldArr = data.getClass().getDeclaredFields();
            //  String fieldName;
            Class fieldType;
            int paramsLen = paramNames.length;
            for(int i=0;i<paramsLen;i++){
                Field field = data.getClass().getField(paramNames[i]);

                fieldType = field.getType();
                if (field.get(data) != null) {
                    if (Integer.class.equals(fieldType)) {
                        statement.setInt(i+1, field.getInt(data));
                    } else if (Double.class.equals(fieldType)) {
                        statement.setDouble(i+1, field.getDouble(data));

                    } else if (String.class.equals(fieldType)) {
                        statement.setString(i+1, field.get(data).toString());

                    } else {
                        throw new IllegalStateException("Unexpected value: " + fieldType);
                    }

                }
            }
        }catch(IllegalAccessException ex){
            System.out.println("IllegalAccessException while setting params "+ex);
        } catch (SQLException e) {
            System.out.println("SQLException while setting params "+e);
        } catch (NoSuchFieldException e) {
            System.out.println("IllegalAccessException while setting params "+e);
        }
        return statement;
    }
    public String[] splitParams(String query){
        int whereIndex = query.toLowerCase().indexOf("where");
        query = query.substring(whereIndex);
        String[] params = query.split("=\\?");
        return params;
    }
}
