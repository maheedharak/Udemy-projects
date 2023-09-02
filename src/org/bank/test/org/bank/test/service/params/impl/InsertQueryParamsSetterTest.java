package org.bank.test.service.params.impl;


import org.bank.source.service.params.ParamsSetter;
import org.bank.source.service.params.impl.InsertQueryParamsSetter;

import org.bank.test.data.QueryDataStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertQueryParamsSetterTest {
    ParamsSetter paramsSetter;

    private static final String insertQuery = "INSERT INTO \"BANK_TABLE\" (\"BRANCH_CODE\",\"ACCOUNT_NUMBER\","+
            "\"CUST_NAME\",\"CUST_ADDRESS\",\"BALANCE\") VALUES "+
            "('999999','99999999','M Kameswari','Wroclaw',690.0)";
    @BeforeEach
    void setUp() {
        paramsSetter = new InsertQueryParamsSetter();

    }

    @Test
    void setParams() {
        StringBuilder insertBuilder = paramsSetter.setParams(QueryDataStub.insertQueryData());
        assertEquals(insertQuery,insertBuilder.toString());
    }
}