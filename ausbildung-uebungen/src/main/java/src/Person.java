package src;

import javax.naming.InvalidNameException;
import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private Gender gender; // Enum statt String
    private Address address; // Klasse statt String
    private LocalDate birthDate;

    // Konstruktor: Nur Name
    public Person(String firstName, String lastName) throws InvalidNameException {
        this(firstName, lastName, Gender.OTHER, null, null);
    }

    // Konstruktor: Name, Geschlecht, Datum
    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate) throws InvalidNameException {
        this(firstName, lastName, gender, null, birthDate);
    }

    // Hauptkonstruktor (nutzt Setter für Resilienz)
    public Person(String firstName, String lastName, Gender gender, Address address, LocalDate birthDate) throws InvalidNameException {
        setFirstName(firstName);
        setLastName(lastName);
        this.gender = (gender != null) ? gender : Gender.OTHER;
        this.address = address;
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) throws InvalidNameException {
        if (!firstName.matches("^[a-zA-Z ÄäÖöÜüß]*$")) {
            throw new InvalidNameException("Ungültige Zeichen ");
        }
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) throws InvalidNameException {
        if (!lastName.matches("^[a-zA-Z ÄäÖöÜüß]*$")) {
            throw new InvalidNameException("Ungültige Zeichen");
        }
        this.lastName = (lastName != null) ? lastName.trim() : "";
    }


    public String getName() {
        try {
            return firstName + " " + lastName;
        }catch (ItemNotFoundException notFond) {
            notFond.getStackTrace();
            System.out.println("Dieser Name ist nicht in der liste ");
        }

        return firstName+" "+lastName;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %s | Geb: %s | Adr: %s",
                gender, getName(),
                (birthDate != null ? birthDate : "k.A."),
                (address != null ? address : "k.A."));
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
