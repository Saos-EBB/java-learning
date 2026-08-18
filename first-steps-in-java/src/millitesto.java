import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class millitesto {
    static void main(String[] args) {

        Random randy = new Random();
        Scanner scan = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<String>();

        String[][] questions = {
                {"Was bedeutet HTML?", "1. HyperText Markup Language", "2. HighText Machine Language", "3. Hyperlink and Text Markup Language", "1"},
                {"Welches Ergebnis liefert folgender Ausdruck: (true&&false||true)", "1. false", "2. true", "2"},
                {"Die Netzwerk-Technik verwendet man ...", "1. beim Fischen", "2. zum Vernetzen von Computern", "2"},
                {"Ein Null-pointer ...", "1. gibt es nicht", "2. ist eine Referenz, die auf kein Objekt zeigt", "3. Datentyp für Text", "4. ärgerlich", "2"},
                {"Eine 'if-Schleife' ist ...", "1. eine Schleif-Machine für Tischler", "2. ein Kündigungsgrund", "3. gibt es nicht", "3"},
                {"Was macht ein Compiler?", "1. Er analysiert Netzwerke", "2. Er führt Programme aus", "3. Er wandelt Quellcode in Maschinencode um", "4. Er speichert Dateien", "3"},
                {"Wofür steht CPU?", "1. Central Processing Unit", "2. Computer Power Unit", "3. Central Print Utility", "1"},
                {"Welche Zahl ist eine Binärzahl?", "1. 101101", "2. 256", "3. 99", "1"},
                {"Was ist ein Objekt in Java?", "1. Eine Instanz einer Klasse", "2. Ein Datentyp für Zahlen", "3. Ein Fehler im Code", "1"},
                {"Welche Schleife wiederholt sich mindestens einmal?", "1. for", "2. do-while", "3. while", "2"}
        };


        for (int i = 0; i < questions.length ; i++){
            history.add(questions[i][0]);
        }

        Collections.shuffle(history);

        for (int i = 0; i < questions.length; i++) {

            System.out.println(questions[i][0] + "\n");

            for (int j = 1; j < questions.length-2; j++) {

                System.out.println(questions[i][j]);



            }


        }






    }
}
