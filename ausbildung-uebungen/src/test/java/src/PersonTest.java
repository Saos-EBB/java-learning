package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testValidPerson() {
        assertDoesNotThrow(() -> new Person("Max", "Mustermann"));
    }

    @Test
    void testInvalidFirstNameShouldThrowException() {
        Exception exception = assertThrows(InvalidPersonNameException.class, () -> {
            new Person("Max123", "Mustermann");
        });
        assertTrue(exception.getMessage().contains("Vorname"));
    }

    @Test
    void testInvalidLastNameShouldThrowException() {
        assertThrows(InvalidPersonNameException.class, () -> {
            new Person("Max", "Muster67mann");
        });
    }
}