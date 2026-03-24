package PM.Management;

import PM.Exceptions.ItemNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PM {

    private final List<Person> persons = new ArrayList<>();
    private final String name;

    public PM(String name) {
        this.name = (name != null) ? name.trim() : "Unbenannt";
    }

    // Person anlegen
    public void createPerson(String fName, String lName) {
        persons.add(new Person(fName, lName));
    }

    public void createPerson(String fName, String lName, Gender gender, LocalDate birthDate) {
        persons.add(new Person(fName, lName, gender, birthDate));
    }

    public void createPerson(String fName, String lName, Gender gender, Address addr, LocalDate birthDate) {
        persons.add(new Person(fName, lName, gender, addr, birthDate));
    }

    // Person suchen — wirft ItemNotFoundException wenn nicht gefunden
    public Person findPersonByLastName(String lName) {
        if (lName == null) throw new ItemNotFoundException("Suchbegriff darf nicht null sein.");

        return persons.stream()
                .filter(p -> p.getLastName().equalsIgnoreCase(lName.trim()))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Person mit Nachnamen '" + lName + "' nicht gefunden."));
    }

    // Person löschen — gibt true zurück wenn jemand entfernt wurde
    public boolean removePerson(String lName) {
        if (lName == null) return false;
        String search = lName.trim().toLowerCase();
        return persons.removeIf(p -> p.getLastName().toLowerCase().equals(search));
    }

    public List<Person> getPersons() {
        return new ArrayList<>(persons);
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
