package org.udemy;

import java.util.Arrays;
import java.util.List;

public class QID_2_1840 {
    List<Integer> ls = Arrays.asList(11,11,22,33,33,55,66);
    public void lazyEvaluation(){
            boolean matched = ls.stream().distinct().anyMatch(x -> x == 11);
            System.out.println(matched);
        }
    public void lazyEvaluation2(){
        boolean matched = ls.stream().distinct().noneMatch(x -> x%11> 0);
        System.out.println(matched);
    }

    }

