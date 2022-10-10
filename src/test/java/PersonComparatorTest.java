import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PersonComparatorTest {
    protected PersonComparator comparator;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Running PersonCompareTest...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("PersonCompareTest completed.");
    }

    @BeforeEach
    void setUp() {
        comparator = new PersonComparator(2);
        System.out.println("Starting a test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed");
    }

    @DisplayName("Testing throwing an exception when person has an empty surname")
    @Test
    void compareWhenPersonHasEmptySurname() {
        Person p1 = new Person("Anrew", "", 22);
        Person p2 = new Person("Vladimir", "Rurikovich", 35);
        Assertions.assertThrows(RuntimeException.class, () -> comparator.compare(p1, p2));
    }

    @DisplayName("Testing comparing when both persons have surnames not less than max size")
    @ParameterizedTest
    @MethodSource("getArgumentsFirst")
    void compareWhenBothSizesMoreOrEqualMaxSize(Person p1, Person p2, int expResult) {
        Assertions.assertEquals(expResult, comparator.compare(p1, p2));
    }

    static Stream<Arguments> getArgumentsFirst() {
        return Stream.of(
                Arguments.of(
                        new Person("Ivan", "The Terrible", 54),
                        new Person("Peter", "The Great", 54),
                        0),
                Arguments.of(
                        new Person("Ivan", "Vasilyevich The Third", 65),
                        new Person("Ivan", "The Terrible", 54),
                        1),
                Arguments.of(
                        new Person("Vladimir", "Rurikovich The Red Sun", 51),
                        new Person("Ivan", "Vasilyevich The Third", 65),
                        -1)
        );
    }

    @DisplayName("Testing comparing when persons both haven't surnames more or equal than max size and their name size equal")
    @ParameterizedTest
    @MethodSource("getArgumentsSecond")
    void compareWhenSizesLessMaxSizeAndEqual(Person p1, Person p2, int expResult) {
        Assertions.assertEquals(expResult, comparator.compare(p1, p2));
    }

    static Stream<Arguments> getArgumentsSecond() {
        return Stream.of(
                Arguments.of(
                        new Person("Dmitry", "Uglitsky", 9),
                        new Person("NikolayII", "Romanov", 50),
                        -1),
                Arguments.of(
                        new Person("AleksandrII", "Nikolaevich", 62),
                        new Person("Nikolay", "Pavlovich", 47),
                        1),
                Arguments.of(
                        new Person("Ivan", "Kalita", 38),
                        new Person("Dmitry", "Donskoy", 38),
                        0)
        );
    }

    @DisplayName("Testing comparing when persons both haven't surnames more or equal than max size and not equal")
    @ParameterizedTest
    @MethodSource("getArgumentsThird")
    void compareToWhenSizesLessMaxSizeAndNotEqual(Person p1, Person p2, int expResult) {
        Assertions.assertEquals(expResult, comparator.compare(p1, p2));
    }

    static Stream<Arguments> getArgumentsThird() {
        return Stream.of(
                Arguments.of(
                        new Person("Ivan", "The Terrible", 54),
                        new Person("Peter", "Romanov", 54),
                        1),
                Arguments.of(
                        new Person("AleksandrII", "Nikolaevich", 62),
                        new Person("Vladimir", "Rurikovich The Red Sun", 51),
                        -1)
        );
    }


}
