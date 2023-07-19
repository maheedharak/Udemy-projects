package org.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class QID_2_1809 {
    public static void averageCalculator(){
        List<Book> bookList = new ArrayList<>(){
            {
             add(new Book("Thinking in Java",30.0));
             add(new Book("Java in 24 hrs",20.0));
             add(new Book("Java Recipes",10.0));
            }
        };
       OptionalDouble average =  bookList.stream()
                .filter(book -> book.getPrice() > 10.0)
                .mapToDouble(x -> x.getPrice())
                .average();
        average.ifPresent(System.out::println);
        OptionalDouble average90 =  bookList.stream()
                .filter(book -> book.getPrice() > 90.0)
                .mapToDouble(x -> x.getPrice())
                .average();
        average90.orElse(0.0);

    }
}
