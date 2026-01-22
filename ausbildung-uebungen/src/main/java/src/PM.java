package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PM {

    private List<Person> persons = new ArrayList<>();
    private String name;

    public PM(String name) {
        this.name = (name != null) ? name.trim() : "Unbenannt";
    }

    public void createPerson(String fName, String lName) {
        persons.add(new Person(fName, lName));
    }

    public void createPerson(String fName, String lName, Gender gender, LocalDate birthDate) {
        persons.add(new Person(fName, lName, gender, birthDate));
    }

    public void createPerson(String fName, String lName, Gender gender, Address addr, LocalDate birthDate) {
        persons.add(new Person(fName, lName, gender, addr, birthDate));
    }

    // Anleitung: Suchen in einer Liste mit Java Streams
    public Person findPersonByLastName(String lName) {
        // 1. Guard-Clause: Verhindert NullPointerExceptions vor dem Stream-Start
        if (lName == null) throw new ItemNotFoundException("Suchbegriff darf nicht null sein.");

        return persons.stream() // 2. Stream öffnen: Macht die Liste 'persons' bereit für die Verarbeitung

                // 3. Filtern: Behält nur Elemente, die die Bedingung erfüllen (Prädikat)
                // .equalsIgnoreCase sorgt für Fehlertoleranz bei Groß-/Kleinschreibung
                .filter(p -> p.getLastName().equalsIgnoreCase(lName.trim()))

                // 4. Finden: Sucht das erste Element, das den Filter passiert hat
                // Gibt ein 'Optional<Person>' zurück (kann ein Ergebnis enthalten oder leer sein)
                .findFirst()

                // 5. Abschluss/Exception: Wenn das Optional leer ist, wird die Exception geworfen.
                // Wenn eine Person gefunden wurde, wird diese direkt zurückgegeben.
                .orElseThrow(() -> new ItemNotFoundException("Person mit Nachnamen '" + lName + "' nicht gefunden."));
    }

    /*
    persons.stream()
    .filter(p -> p.getAge() > 18)  // 1. Filtern
    .map(Person::getLastName)      // 2. Umwandeln (nur Namen)
    .sorted()                      // 3. Sortieren
    .limit(5)                      // 4. Begrenzen
    .toList();                     // 5. Ergebnis sammeln
     */

    public void removePerson(String lName) {
        if (lName != null) {
            String search = lName.trim().toLowerCase();
            persons.removeIf(p -> p.getName().toLowerCase().contains(search));
        }
    }

    public List<Person> getPersons() {
        return new ArrayList<>(persons); // Defensive Kopie
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Verwaltung: " + name + "\n");
        for (Person p : persons) {
            sb.append(" - ").append(p).append("\n");
        }
        return sb.toString();
    }
}
