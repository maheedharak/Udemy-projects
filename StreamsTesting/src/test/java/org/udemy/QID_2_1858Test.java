package org.udemy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class QID_2_1858Test {
    private QID_2_1858 qid21858;

    @BeforeEach
    void setUp() {
        qid21858 = new QID_2_1858();
    }
    @Test
    public void booksListTest(){
        qid21858.booksList();
    }
}