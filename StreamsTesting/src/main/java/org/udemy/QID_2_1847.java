package org.udemy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QID_2_1847 {
    public void mapTesting(){
        List<Book> bookLst = Arrays.asList(new Book("Gone with the wind",5.0),
                                            new Book("Gone with the wind",10.0),
                                            new Book("Atlas shrugged",15.0));
        bookLst.stream()
                .collect(Collectors.toMap(book-> book.getTitle(), book -> book.getPrice(),(key1,key2) -> key1+key2))
                .entrySet()
                .forEach(entry -> System.out.println(entry.getKey() +" "+entry.getValue()));


    }
}
