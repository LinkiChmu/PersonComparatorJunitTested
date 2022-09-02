import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Наиля", "Хаджи Мурат ибн Аскерзаде", 10));
        people.add(new Person("Патрис", "Ле -Ланн", 14));
        people.add(new Person("Руслан", "Кара Мурза Хоттаб", 20));
        people.add(new Person("Иван", "Петров", 45));
        System.out.println(people);

        Comparator<Person> myComparator = (o1, o2) -> {
            int nobility1 = o1.getSurname().split("(?U)\\W+").length;
            int nobility2 = o2.getSurname().split("(?U)\\W+").length;
            int maxNumberWordsToCompare = 3;
            // if both surnames consist of the number of words not less than the maximum, compare them by age
            if (nobility1 >= maxNumberWordsToCompare && nobility2 >= maxNumberWordsToCompare) {
                return o1.compareTo(o2);
            } else {
                int compareNobility = Integer.compare(nobility1, nobility2);
                // if they equal, compare ages of persons
                return (compareNobility == 0) ? o1.compareTo(o2) : compareNobility;
            }
        };
        Collections.sort(people, myComparator);
        System.out.println(people);
    }
}