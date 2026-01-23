package PM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PMExTest {

    private PM verwaltung;

    @BeforeEach
    void setUp() {
        verwaltung = new PM("Test");
        verwaltung.createPerson("Max", "Mustermann");
    }

    @Test
    @DisplayName(" i hob wos gfundn -funkt ")
    void testFindPersonSuccess() {
        Person p = verwaltung.findPersonByLastName("Mustermann");
        assertNotNull(p);
        assertEquals("Mustermann", p.getLastName());
    }

    @Test
    @DisplayName("i find nix -funkt")
    void testFindPersonNotFound_ShouldThrowException() {
        assertThrows(ItemNotFoundException.class, () -> {
            verwaltung.findPersonByLastName("GibtEsNicht");
        });
    }
}
