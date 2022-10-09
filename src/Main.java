import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Наиля", "Хаджи Мурат ибн Аскерзаде", 10));
        people.add(new Person("Патрис", "Ле -Ланн", 14));
        people.add(new Person("Руслан", "Кара Мурза Хоттаб", 20));
        people.add(new Person("Иван", "Петров", 45));
        System.out.println(people);

        people.sort(new PersonComparator(3));
        System.out.println(people);

        System.out.println(adultOnly(people));
    }
    public static List<Person> adultOnly(List<Person> people) {
        List <Person> adults = people.stream()
                .filter(person -> (person.getAge() >= 18))
                .collect(Collectors.toList());
        return adults;
    }
}