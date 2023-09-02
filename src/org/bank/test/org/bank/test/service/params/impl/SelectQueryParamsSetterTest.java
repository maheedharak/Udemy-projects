package org.bank.test.service.params.impl;


import org.bank.source.service.params.ParamsSetter;
import org.bank.source.service.params.impl.DeleteQueryParamsSetter;
import org.bank.test.data.QueryDataStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SelectQueryParamsSetterTest {
    ParamsSetter paramsSetter;

    private static final String deleteQuery = "SELECT * FROM \"BANK_TABLE\" WHERE "+
            "\"BRANCH_CODE\" = '123456' AND \"ACCOUNT_NUMBER\" = '12345678'";

    @BeforeEach
    void setUp() {
        paramsSetter = new DeleteQueryParamsSetter();
    }

    @Test
    void setParams() {
        StringBuilder updateBuilder = paramsSetter.setParams(QueryDataStub.selectQueryData());
        assertNotNull(updateBuilder);
        assertEquals(deleteQuery, updateBuilder.toString());

    }
}
