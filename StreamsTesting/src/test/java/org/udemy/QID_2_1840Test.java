package org.udemy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class QID_2_1840Test {
    private QID_2_1840 qid21840;
    @BeforeEach
    void setUp() {
        qid21840 = new QID_2_1840();
    }

    @Test
    void lazyEvaluationTest() {
        qid21840.lazyEvaluation();
    }

    @Test
    void lazyEvaluation2Test() {
        qid21840.lazyEvaluation2();
    }
}