package PM;

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
    @DisplayName("Create person - anlegen funkt ")
    void testCreatePerson() throws Exception {
        verwaltung.createPerson("Max", "Mustermann");
        assertEquals(1, verwaltung.getPersons().size(), "Die Liste sollte genau eine Person enthalten.");
        assertEquals("Mustermann", verwaltung.getPersons().get(0).getLastName(), "Der Nachname stimmt nicht überein.");
    }

    @Test
    @DisplayName("Create Multiple Persons - funkt")
    void testCreateMultiplePersons() throws Exception {
        verwaltung.createPerson("Max", "Mustermann");
        verwaltung.createPerson("Erika", "Musterfrau");
        assertEquals(2, verwaltung.getPersons().size());
    }

    @Test
    @DisplayName("Löschen über Nachname - funkt")
    void testRemovePerson() {
        verwaltung.createPerson("Max", "Mustermann");
        verwaltung.removePerson("MUSTERMANN"); // Testet Case-Insensitivity
        assertTrue(verwaltung.getPersons().isEmpty(), "Die Liste sollte nach dem Löschen leer sein.");
    }

    @Test
    @DisplayName("löschen von nicht existenten daten Löscht nix -funkt ")
    void testRemoveNonExistentPerson() throws Exception {
        verwaltung.createPerson("Max", "Mustermann");
        verwaltung.removePerson("Schmidt");
        assertEquals(1, verwaltung.getPersons().size(), "Die Liste sollte immer noch ein Element enthalten.");
    }

    @Test
    @DisplayName("Löschen von 'null' löscht nix -funkt")
    void testRemoveNull() throws Exception {
        verwaltung.createPerson("Max", "Mustermann");
        assertDoesNotThrow(() -> verwaltung.removePerson(null));
        assertEquals(1, verwaltung.getPersons().size());
    }
}
