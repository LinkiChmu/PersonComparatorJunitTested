import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Наиля", "Хаджи Мурат ибн Аскерзаде", 10));
        people.add(new Person("Патрис", "Ле -Ланн", 14));
        people.add(new Person("Руслан", "Кара Мурза Хоттаб", 20));
        people.add(new Person("Иван", "Петров", 45));
        System.out.println(people);
        Collections.sort(people, new PersonComparator(3));
        System.out.println(people);
    }
}
