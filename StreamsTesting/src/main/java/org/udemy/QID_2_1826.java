package org.udemy;

import java.util.Optional;

public class QID_2_1826 {
    public Optional<String> getGrade(int marks){
        Optional<String> grade = Optional.empty();
        if(marks > 50){
            grade = Optional.of("PASS");
        }else{
            grade = Optional.of("FAIL");
        }
        return grade;
    }
}
