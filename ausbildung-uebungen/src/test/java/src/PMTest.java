package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class PMTest {
    private PM verwaltung;

    @BeforeEach
    void setUp() {
        verwaltung = new PM("Test-Verwaltung");
    }

    @Test
    @DisplayName("Person sollte erfolgreich zur Liste hinzugefügt werden")
    void testCreatePerson() throws Exception {
        verwaltung.createPerson("Max", "Mustermann");
        assertEquals(1, verwaltung.getPersons().size(), "Die Liste sollte genau eine Person enthalten.");
        assertEquals("Mustermann", verwaltung.getPersons().get(0).getLastName(), "Der Nachname stimmt nicht überein.");
    }

    @Test
    @DisplayName("Mehrere Personen sollten korrekt hinzugefügt werden")
    void testCreateMultiplePersons() throws Exception {
        verwaltung.createPerson("Max", "Mustermann");
        verwaltung.createPerson("Erika", "Musterfrau");
        assertEquals(2, verwaltung.getPersons().size());
    }

    @Test
    @DisplayName("Löschen einer Person über den Nachnamen (Case-Insensitive)")
    void testRemovePerson() {
        verwaltung.createPerson("Max", "Mustermann");
        verwaltung.removePerson("MUSTERMANN"); // Testet Case-Insensitivity
        assertTrue(verwaltung.getPersons().isEmpty(), "Die Liste sollte nach dem Löschen leer sein.");
    }

    @Test
    @DisplayName("Löschen einer nicht existierenden Person sollte Liste unverändert lassen")
    void testRemoveNonExistentPerson() throws Exception {
        verwaltung.createPerson("Max", "Mustermann");
        verwaltung.removePerson("Schmidt");
        assertEquals(1, verwaltung.getPersons().size(), "Die Liste sollte immer noch ein Element enthalten.");
    }

    @Test
    @DisplayName("Null-Check beim Löschen")
    void testRemoveNull() throws Exception {
        verwaltung.createPerson("Max", "Mustermann");
        assertDoesNotThrow(() -> verwaltung.removePerson(null));
        assertEquals(1, verwaltung.getPersons().size());
    }
}
