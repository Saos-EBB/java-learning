package PM;

import PM.Exceptions.InvalidPersonNameException;
import PM.Management.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testValidPerson() {
        assertDoesNotThrow(() -> new Person("Max", "Mustermann"));
    }

    @Test
    @DisplayName("Vorname Eingabe invalid (zahlen) - funkt")
    void testInvalidFirstNameShouldThrowException() {
        Exception exception = assertThrows(InvalidPersonNameException.class, () -> {
            new Person("Max123", "Mustermann");
        });
        assertTrue(exception.getMessage().contains("Vorname"));
    }

    @Test
    @DisplayName("Nachname Eingabe invalid (Sonderzeichen) - funkt")
    void testInvalidLastNameShouldThrowException() {
        assertThrows(InvalidPersonNameException.class, () -> {
            new Person("Max", "Muster#?mann");
        });
    }


}