package org.collections;

import java.util.*;

public class ListSample {
    public void listTest(){
        List<Integer> intLst = new ArrayList<>(){
            {
                add(10);
                add(20);
            }
        };
        List<Integer> intLstNew =  List.copyOf(intLst);
     //   intLstNew.replaceAll(x -> x*5);
        List<Integer> intLst1 = Arrays.asList(10,20);
        intLst1.replaceAll(x -> x*5);
        intLst1.set(1,35);
        List<Integer> intLstNew2 = Collections.unmodifiableList(intLst);
        intLstNew2.replaceAll(x -> x*5);


    }
}
