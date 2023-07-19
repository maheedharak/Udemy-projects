package org.udemy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QID_2_1787 {
    public void flatMapStream(){
        Stream<List<String>> flatMapStream = Stream.of(Arrays.asList("a","b"),Arrays.asList("a","c"));

        flatMapStream.filter(lst -> lst.contains("c"))
                .flatMap(lst -> lst.stream())
                .forEach(System.out::println);

    }
}
