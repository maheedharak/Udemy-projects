package org.udemy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QID_Q2_1762 {
    public void streamNames(){
        System.out.println("into stream names");
        List<Item> itemList = new ArrayList<>(){
            {
            add(new Item(1,"Screw"));
            add(new Item(2,"Nail"));
            add(new Item(3,"Bolt"));

        }
        };
        itemList.stream()
                .peek(item -> System.out.println(item.getName()))
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::println);

    }
}
