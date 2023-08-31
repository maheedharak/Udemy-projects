package org.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListSampleTest {
    private ListSample listSample;

    @BeforeEach
    void setUp() {
        listSample = new ListSample();
    }
    @Test
    public void listTest(){
        listSample.listTest();
    }
}