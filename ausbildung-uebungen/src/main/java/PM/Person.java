package PM;

import java.time.LocalDate;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Address address;
    private LocalDate birthDate;

    // Konstruktoren delegieren an den Hauptkonstruktor!
    public Person(int id,String firstName, String lastName) {
        this(id ,firstName, lastName, Gender.OTHER, null, null);
    }

    public Person(int id,String firstName, String lastName, Gender gender, LocalDate birthDate) {
        this(id,firstName, lastName, gender, null, birthDate);
    }
    //Hauptkonstruktor!
    public Person(int id,String firstName, String lastName, Gender gender, Address address, LocalDate birthDate) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        this.gender = (gender != null) ? gender : Gender.OTHER;
        this.address = address;
        this.birthDate = birthDate;
    }

    //Setter
    //FIXX
    public void setFirstName(String firstName) {
        if (firstName == null || !firstName.matches("^[a-zA-Z ÄäÖöÜüß]+$")) {
            throw new InvalidPersonNameException("Ungültiger Vorname (keine Zahlen erlaubt): " + firstName);
        }
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        if (lastName == null || !lastName.matches("^[a-zA-Z ÄäÖöÜüß]+$")) {
            throw new InvalidPersonNameException("Ungültiger Nachname (keine Zahlen erlaubt): " + lastName);
        }
        this.lastName = lastName.trim();
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter
    public String getName() {
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %s | Geb: %s | Adr: %s",
                gender, getName(),
                (birthDate != null ? birthDate : "k.A."),
                (address != null ? address : "k.A."));
    }
}