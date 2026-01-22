import java.util.HashMap;
import java.util.Scanner;

public class Wörterbuch {

    public static HashMap<String, String> gerToEng = new HashMap<>();
    public static HashMap<String, String> engToGer = new HashMap<>();

    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;

        while (run) {

            System.out.println("\nWas willst du machen?\n1 = Wort hinzufügen\n2 = Wort suchen\n3 = Wort löschen\n4 = Ende\n-> ");
            String choice = scan.next();
            switch (choice) {
                case "1": // add
                    addWords();
                    break;
                case "2": // search
                    System.out.print("Wort eingeben zum Suchen: ");
                    String keyS = scan.next().toUpperCase();

                    String result = search(keyS);

                    if (result.equals("Nope")) {
                        System.out.println("Nicht gefunden.\nWillst du das Wort hinzufügen ? (true/false)");
                        boolean add = scan.nextBoolean();
                        if (add) addWords();
                    } else {
                        System.out.println("Gefunden: " + result);
                    }
                    break;
                case "3": // delete
                    System.out.print("Wort eingeben zum Löschen: ");
                    String keyD = scan.next().toUpperCase();

                    delete(keyD);
                    System.out.println("Fertig.");
                    break;
                case "4": // exit
                    run = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe.");
            }
        }

        System.out.println("Ende.");
    }//Ente!

    // add key + value "über kreuz"
    public static void addWords() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Zum Hinzufügen bitte erst das deutsche Wort eingeben.\n-> ");
        String ger = scan.next().toUpperCase(), keyGer = ger, valGer = ger;

        System.out.println("Nun das englische Wort eingeben.\n-> ");
        String eng = scan.next().toUpperCase(), keyEng = eng, valEng = eng;

        gerToEng.put(keyGer, valEng);
        engToGer.put(keyEng, valGer);
    }

    // gib value zu key -> suchen
    public static String search(String key) {
        if (gerToEng.containsKey(key)) return gerToEng.get(key);
        if (engToGer.containsKey(key)) return engToGer.get(key);
        // key existiert nicht
        return "Nope";
    }

    // delete key and values aus beiden listen
    public static void delete(String key) {
        // prüfen ob key existiert in ger->eng
        if (gerToEng.containsKey(key)) {
            // engl. Wort zum Löschen finden
            String val = gerToEng.get(key);
            // löschen
            gerToEng.remove(key);
            engToGer.remove(val);
        }

        // prüfen ob key existiert in eng->ger
        if (engToGer.containsKey(key)) {
            // deutsches Wort zum Löschen finden
            String val = engToGer.get(key);
            // löschen
            engToGer.remove(key);
            gerToEng.remove(val);
        }
    }

}