package PM.Management;

import PM.Exceptions.InvalidPersonNameException;

import java.time.LocalDate;

public class Person {

    private String firstName;
    private String lastName;
    private Gender gender;
    private Address address;
    private LocalDate birthDate;

    // Konstruktoren delegieren an den Hauptkonstruktor
    public Person(String firstName, String lastName) {
        this(firstName, lastName, Gender.OTHER, null, null);
    }

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        this(firstName, lastName, gender, null, birthDate);
    }

    public Person(String firstName, String lastName, Gender gender, Address address, LocalDate birthDate) {
        setFirstName(firstName);
        setLastName(lastName);
        this.gender    = (gender != null) ? gender : Gender.OTHER;
        this.address   = address;
        this.birthDate = birthDate;
    }

    // Setter mit Validierung
    public void setFirstName(String firstName) {
        if (firstName == null || !firstName.matches("^[a-zA-Z ÄäÖöÜüß]+$")) {
            throw new InvalidPersonNameException("Ungültiger Vorname: " + firstName);
        }
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        if (lastName == null || !lastName.matches("^[a-zA-Z ÄäÖöÜüß]+$")) {
            throw new InvalidPersonNameException("Ungültiger Nachname: " + lastName);
        }
        this.lastName = lastName.trim();
    }

    // Getter
    public String getName() {
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %s | Geb: %s | Adr: %s",
                gender,
                getName(),
                (birthDate != null ? birthDate : "k.A."),
                (address   != null ? address   : "k.A."));
    }
}
