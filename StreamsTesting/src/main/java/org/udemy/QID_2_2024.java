package org.udemy;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class QID_2_2024 {
    public void filterOdd(){
        DoubleStream stream = DoubleStream.of(0,2,4);
        double sum = stream.filter(x -> x != 0 && x%2!=0).sum();
        System.out.println(sum);

    }
    public void calculateAverage(){
        Stream<Double> stream = Stream.of(1.0d,3.0d);
        double average = stream.mapToDouble(d -> d)
                .filter(x -> x!= 0 && x%2 == 0)
                .average()
                .orElse(0.0);

        System.out.println(average);
    }
}
