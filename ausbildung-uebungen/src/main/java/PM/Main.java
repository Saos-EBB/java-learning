package PM;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static PM_Appl app = new PM_Appl();

    public static void main(String[] args) {



        while (true) {
            System.out.println("\n--- HAUPTMENÜ ---");
            System.out.println("[1] Standort anlegen");
            System.out.println("[2] Person hinzufügen (Resilient)");
            System.out.println("[3] Person suchen (ItemNotFound Test)");
            System.out.println("[4] Alle Daten anzeigen");
            System.out.println("[5] Beenden");
            System.out.print("Wahl: ");

            String wahl = menu();
            if (wahl.equals("5")) break;

            switch (wahl) {
                case "1" -> addLocation();
                case "2" -> addPerson();
                case "3" -> findPersonData();
                case "4" -> showData();
                default -> System.out.println("Ungültige Wahl.");
            }
        }
    }

    private static void addLocation() {
        System.out.print("Name des Standorts: ");
        String in = keineSonderzeichen();
        if (app.add(in)) System.out.println("Standort angelegt.");
        else System.out.println("Fehler beim Anlegen.");
    }


    private static void addPerson() {
        System.out.print("Ziel-Standort eingeben (ID oder Name): ");
        String ziel = keineSonderzeichen();
        PM target = app.get(ziel);

        if (target == null) {
            System.out.println("Standort existiert nicht.");
            return;
        }

        String vn = getValidNameInput("Vorname");
        String nn = getValidNameInput("Nachname");


        System.out.print("Geschlecht (M/W/O): ");
        String gIn = sc.nextLine().toUpperCase();
        Gender gender = switch (gIn) {
            case "M" -> Gender.MAN;
            case "W" -> Gender.WOMAN;
            default -> Gender.OTHER;
        };

        // Adresse anlegen
        System.out.print("PLZ: "); String plz = nurZahlen();
        System.out.print("Stadt: "); String stadt = keineSonderzeichen();
        System.out.print("Str: ");String str = keineSonderzeichen();
        System.out.print("Hausnummer: ");String hr = nurZahlen();
        Address addr = new Address(plz, stadt, str, hr);

        // Datum
        LocalDate bDate = null;
        try {
            System.out.print("Geburtsdatum (JJJJ-MM-TT): ");
            String d = kuchenTag();
            if(!d.isBlank()) bDate = LocalDate.parse(d);
        } catch (DateTimeParseException e) {
            System.out.println("Format falsch, Datum wird leer gelassen.");
        }

        try {
            target.createPerson(vn, nn, gender, addr, bDate);
            System.out.println("Person erfolgreich erstellt!");
        } catch (InvalidPersonNameException e) {
            System.out.println("Unerwarteter Fehler: " + e.getMessage());
        }
    }

    // Hilfsmethode für die Wiederholung der Eingabe
    private static String getValidNameInput(String label) {
        while (true) {
            System.out.print(label + ": ");
            String input = sc.nextLine();

            try {
                // Check durchführen
                if (!input.matches("^[a-zA-Z ÄäÖöÜüß]+$")) {
                    throw new InvalidPersonNameException("Zahlen oder Sonderzeichen sind verboten.");
                }
                return input; // Wenn okay, raus aus der Schleife
            } catch (InvalidPersonNameException e) {
                System.out.println("Fehler: " + e.getMessage() + " -> Bitte erneut eingeben.");
            }
        }
    }

    private static void findPersonData() {
        System.out.print("In welchem Standort suchen? ");
        PM pm = app.get(keineSonderzeichen());
        if (pm == null) {
            System.out.println("Standort nicht gefunden.");
            return;
        }

        System.out.print("Nachname der gesuchten Person: ");
        String searchName = keineSonderzeichen();

        try {
            Person p = pm.findPersonByLastName(searchName);
            System.out.println("Gefunden: " + p);
        } catch (ItemNotFoundException e) {

            // OPTIONALE AUFGABE: Stacktrace auf System.out
            System.out.println("--- Exception gefangen ---");
            e.printStackTrace(System.out);
            System.out.println("--------------------------");
            System.out.println("Bitte versuchen Sie einen anderen Namen.");
        }
    }

    private static void showData() {
        System.out.println(app);
    }
    //InputsMethoden
    private static String keineSonderzeichen() {
        String in;
        while (true) {
            in = sc.nextLine();
            if (in.matches("^[a-zA-Z ÄäÖöÜüß]+$")) break;
            else System.out.println("Keine Sonderzeichen");
        }
        return in.trim().toLowerCase();
    }

      private static String nurZahlen() {
        String in;
        while (true) {
             in = sc.nextLine();
             if (in.matches("^[0-9]+$"))break;
            System.out.println("Nur Zahlen");
        }
        return in.trim();
    }
    private static String kuchenTag() {
        String in;
        while (true) {
             in = sc.nextLine();
             if (in.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))break;
            System.out.println("Format : XXXX-XX-XX");
        }
        return in.trim();
    }

    private static String menu() {
        String in;
        while (true) {
             in = sc.nextLine();
             if (in.matches("[0-5]"))break;
            System.out.println("0-5");
        }
        return in.trim();
    }





    }


