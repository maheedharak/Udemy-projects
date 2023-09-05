package org.bank.test;


import org.bank.source.model.Queries;
import org.bank.source.utility.ParametersSetter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParametterSetterTest {
    private ParametersSetter paramSetter;
    @BeforeEach
    public void setup(){
        paramSetter = new ParametersSetter();
    }

    @Test
    @Disabled
    public void splitParamsTest(){
        List<String> params = paramSetter.splitParams(Queries.DELETE_1_QUERY);
        Assertions.assertEquals("branchcode",params.get(0));
        Assertions.assertEquals("accountnumber",params.get(1));

    }

}

