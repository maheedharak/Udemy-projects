package org.udemy;


import java.util.Optional;

public class QID_2_1849 {
    public void optionalTesting(){
        Optional<Double> price = Optional.ofNullable(20.0);
        price.ifPresent(System.out::println);
        price.orElse(0.0);
        price.orElseGet(()-> 10.0);


        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println(price2);
        if(price2.isEmpty())
            System.out.println("empty");
        price2.ifPresent(System.out::println);
        Double x = price2.orElse(44.0);
        System.out.println(x);


        Optional<Double> price3 = Optional.ofNullable(null);
        Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
        System.out.println(z);
    }
}
