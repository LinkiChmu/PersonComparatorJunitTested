import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    private int maxNumberWordsToCompare;

    @Override
    public int compare(Person o1, Person o2) {
        // compare numbers or words in surnames of persons
        int nobility1 = o1.getSurname().split("(?U)\\W+").length;
        int nobility2 = o2.getSurname().split("(?U)\\W+").length;
        // if both surnames consist of the number of words not less than the maximum, compare them by age
        if (nobility1 >= maxNumberWordsToCompare && nobility2 >= maxNumberWordsToCompare) {
            return o1.compareTo(o2);
        } else {
            int compareNobility = Integer.compare(nobility1, nobility2);
            // if they equal, compare ages of persons
            return (compareNobility == 0) ? o1.compareTo(o2) : compareNobility;
        }
    }

    public PersonComparator(int maxNumberWordsToCompare) {
        this.maxNumberWordsToCompare = maxNumberWordsToCompare;
    }
}