import org.udemy.*;

import java.util.Optional;

public class Caller {
    public static void main(String[] args){
        QID_2_2023 qid22023 = new QID_2_2023();
      qid22023.streamIntegers();
        QID_Q2_1762 qidq21762 = new QID_Q2_1762();
       qidq21762.streamNames();
        QID_2_1787 qid21787 = new QID_2_1787();
      qid21787.flatMapStream();
        QID_2_1738 qid21738 = new QID_2_1738();
        qid21738.sumIntStream();
        qid21738.comparatorStream();
        qid21738.integerComparator();
        QID_2_1826 qid21826 = new QID_2_1826();
        Optional<String> grade1 = qid21826.getGrade(50);
        Optional<String> grade2 = qid21826.getGrade(55);
        grade1.ifPresent(System.out::println);
        grade1.orElse("UNKNOWN");
        grade2.ifPresent(System.out::println);
        grade2.orElse("Empty");
         QID_2_1809.averageCalculator();
        QID_2_1846 qid21846 = new QID_2_1846();
        qid21846.mapper();
        QID_2_1847 qid21847 = new QID_2_1847();
        qid21847.mapTesting();
        QID_2_1810 qid21810 = new QID_2_1810();
        qid21810.filterWithMap();
        QID_2_1849 qid21849 = new QID_2_1849();
        qid21849.optionalTesting();
    }

}
