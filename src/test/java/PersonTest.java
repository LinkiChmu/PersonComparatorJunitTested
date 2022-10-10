import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Testing: Person")
public class PersonTest {

    @BeforeAll
    static void setUpAll() {
        System.out.println("Running PersonTest...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("PersonTest complete.");
    }
     @BeforeEach
    void setUp() {


         System.out.println("Starting a test");
    }
    @AfterEach
    void tearDown() {
        System.out.println("Test completed");
    }


    @DisplayName("Testing compare persons by age")
    @ParameterizedTest
    @MethodSource("getArguments")
    void compareTo(Person person, Person other, int expResult) {
        Assertions.assertEquals(expResult, person.compareTo(other));
    }

    static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of(
                        new Person("Ivan", "The Terrible", 54),
                        new Person("Peter", "The Great", 54),
                        0),
                Arguments.of(
                        new Person("Dmitry", "Uglitsky", 9),
                        new Person("Ivan", "Vasilyevich The Third", 65),
                        -1),
                Arguments.of(
                        new Person("Nikolay", "Romanov",50),
                        new Person("Mikhail", "Fedorovich", 49),
                        1),
                Arguments.of(
                        new Person("Konstantin", "", 55),
                        new Person("Nikolay", "", 28),
                        1)
                );
    }

    @DisplayName("Testing when the argument is null")
    @Test
    void compareTo() {
        Person person = new Person("Ivan", "The Terrible", 54);
        Person other = null;
        Assertions.assertThrows(NullPointerException.class, () -> person.compareTo(other));
    }
}
