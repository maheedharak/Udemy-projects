package org.bank.test.service.params.impl;

import org.bank.source.service.params.ParamsSetter;
import org.bank.source.service.params.impl.UpdateQueryParamsSetter;
import org.bank.test.data.QueryDataStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UpdateQueryParamsSetterTest {

    ParamsSetter paramsSetter;

    private static final String updateStr = "UPDATE \"BANK_TABLE\" SET \"CUST_ADDRESS\" = 'Poland',\"BALANCE\" = 0.0"+
            " where \"BRANCH_CODE\" = '123456' AND \"ACCOUNT_NUMBER\" = '12345678' AND "+
            "\"CUST_NAME\" = 'Joe Bloggs' AND \"CUST_ADDRESS\" = 'Athlone' AND \"BALANCE\" = 300.0";

    @BeforeEach
    public void setup() {
        paramsSetter = new UpdateQueryParamsSetter();
    }

    @Test
    void setUpdateParamsTest() {
        StringBuilder updateBuilder = paramsSetter.setParams(QueryDataStub.updateQueryData());
        assertEquals(updateStr,updateBuilder.toString());
    }
}