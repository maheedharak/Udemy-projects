package org.udemy;

import java.util.Arrays;
import java.util.List;

public class QID_2_1810 {
    public void filterWithMap(){
        List<Person> personLst = Arrays.asList(new Person("Bob","",31),
                                              new Person("Paul","",32),
                                              new Person("John","",33));
       double averageAge = personLst.stream()
                . filter(person -> person.getAge() < 30)
                .mapToInt(x -> x.getAge())
                .average()
                .orElse(0.0);
       System.out.println(averageAge);
    }
}
