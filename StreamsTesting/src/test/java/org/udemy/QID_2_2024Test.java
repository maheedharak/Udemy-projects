package org.udemy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class QID_2_2024Test {

    private QID_2_2024 qid22024;
    @BeforeEach
    void setUp() {
        qid22024 = new QID_2_2024();
    }

    @Test
    void filterOddTest() {
        qid22024.filterOdd();
    }

    @Test
    void calculateAverageTest() {
        qid22024.calculateAverage();
    }
}