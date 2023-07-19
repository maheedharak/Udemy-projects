package org.udemy;

import java.util.*;

public class QID_2_1738 {
    public void sumIntStream(){
        List<Integer> intLst = Arrays.asList(1,2,3);
        int sum = intLst.stream().mapToInt(x -> x).sum();
        System.out.println("sum is "+sum);
        OptionalInt maxValue = intLst.stream().mapToInt(x -> x).max();
        maxValue.ifPresent(System.out::println);
    }
    public void comparatorStream(){
        List<Person> personList = Arrays.asList(new Person("Alan","Burke",22),
                                                new Person("Zoe","Peters",20),
                                                new Person("Peter","Castle",29));
        Optional<Person> maxAge = personList.stream().max(Comparator.comparing(Person::getAge));
        maxAge.ifPresent(System.out::println);
    }
    public void integerComparator(){
        List<Integer> intLst = Arrays.asList(10,47,33,23);
        Optional<Integer> maxOptional = intLst.stream().reduce((n1,n2) -> Integer.max(n1,n2));
        maxOptional.ifPresent(System.out::println);
        int maxValue = intLst.stream().reduce(intLst.get(0),(n1,n2) ->  Integer.max(n1,n2));
        System.out.println(maxValue);
    }
}
