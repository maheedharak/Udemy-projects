package org.udemy;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class QID_2_2023 {
    public void streamIntegers(){
        OptionalDouble average = IntStream.rangeClosed(0,5).average();
        average.ifPresent(System.out::println);
    }
}
