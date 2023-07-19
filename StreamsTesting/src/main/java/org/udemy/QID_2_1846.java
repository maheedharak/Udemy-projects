package org.udemy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QID_2_1846 {
    public void mapper(){
        List<Book> bookLst = Arrays.asList(new Book("Atlas Shrugged",10.0),
                                           new Book("Freedom at Midnight",5.0),
                                           new Book("Gone with the wind",5.0));
        Map<String,Double> bookMap = bookLst.stream().collect(Collectors.toMap(book -> book.getTitle(),book -> book.getPrice()));
        bookMap.entrySet()
                .stream()
                .forEach(entry -> {
                    if(entry.getKey().startsWith("A"))
                        System.out.println(entry.getValue());
                });
    }
}
