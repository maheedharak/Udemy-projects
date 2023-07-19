package org.udemy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class QID_2_1858 {
    public void booksList(){
        List<AnotherBook> books = Arrays.asList(new AnotherBook("Gone with the wind","Fiction"),
                                                new AnotherBook("Bourne Ultimatum","Thriller"),
                                                new AnotherBook("The Client","Thriller"));
        List<String> genreList;
        genreList = books.stream().map(book -> book.getGenre()).collect(Collectors.toList());
        genreList.forEach(System.out::println);


    }
}
