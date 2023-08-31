package org.bank;

import org.bank.model.Queries;
import org.bank.utility.ParametersSetter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParametterSetterTest {
    private ParametersSetter paramSetter;
    @BeforeEach
    public void setup(){
        paramSetter = new ParametersSetter();
    }

    @Test
    public void splitParamsTest(){
        String[] params = paramSetter.splitParams(Queries.DELETE_1_QUERY);
        Assertions.assertEquals(params[0],"branchCode");
        Assertions.assertEquals(params[1],"accountNumber");

    }

}

