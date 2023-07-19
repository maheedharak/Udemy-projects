package org.udemy;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class QID_2_1841 {
    public static void main(String[] args){
        AtomicInteger ai = new AtomicInteger();
        Stream.of(11,11,22,33)
                .parallel()
                .filter(n -> {
                    System.out.println(n);
                    System.out.println(ai);
                    ai.incrementAndGet();
                    return n%2 == 0;
        });
        System.out.println(ai);
    }
}
