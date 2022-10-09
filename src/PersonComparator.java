import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    private final int MAX_SIZE;

    public PersonComparator(int maxNumberWordsToCompare) {
        this.MAX_SIZE = maxNumberWordsToCompare;
    }

    @Override
    public int compare(Person o1, Person o2) {
        // count numbers or words in surnames of persons
        int nameSize1 = o1.getSurname().split("(?U)\\W+").length;
        int nameSize2 = o2.getSurname().split("(?U)\\W+").length;
        // if both surnames consist of the number of words not less than the maximum, compare them by age
        // using overridden for Person method 'compareTo'
        if (nameSize1 >= MAX_SIZE && nameSize2 >= MAX_SIZE) {
            return o1.compareTo(o2);
        // else compare persons by the name size
        } else {
            int compareNameSize = Integer.compare(nameSize1, nameSize2);
            // if they equal, compare ages of persons
            return (compareNameSize == 0) ? o1.compareTo(o2) : compareNameSize;
        }
    }


}