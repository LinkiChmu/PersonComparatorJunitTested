public class Person implements Comparable<Person> {
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        if (age < other.age) {
            return -1;
        } else if (age > other.age) {
            return 1;
        } else {
            return 0;
        }
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return surname + " = " + age;
    }


}
