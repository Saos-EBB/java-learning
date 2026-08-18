import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class cybersec {


    public static final String RESET = "\u001B[0m"; // Setzt alle Farben und Formatierungen zurück
    public static final String FG_MAGENTA = "\u001B[35m"; // Magentafarbener Text

    static void main(String[] args) {
        Random randy = new Random();

        ArrayList<Integer> history1 = new ArrayList<>();
        ArrayList<Integer> history2 = new ArrayList<>();
        char[] validInputs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstvwxyz0123456789!?+-#.,:;_*'<>|ß}".toCharArray();
        char[] password1 = new char[6];
        char[] password2 = new char[6];
        char[] test1 = new char[6];
        char[] test2 = new char[6];


        boolean found1 = false, found2 = false;
        int counter1 = 0, counterP1 = 0, save1 = 0, mean1 = 0;
        int Versuche = 0, richtigeVersuche = 0, Versucheaddiren = 0, mean2 = 0;

        boolean klick = false, Version1 = false;
        boolean klick2 = true, Version2 = true;
        int range = 100;

        String format = "\n%1s%1s%1s%1s\n";


        // Randy
        for (int i = 0; i < password1.length; i++) {
            password1[i] = validInputs[randy.nextInt(validInputs.length)];
        }
        System.out.println("Das Passwort ist : " + FG_MAGENTA + Arrays.toString(password1) + RESET + "\nVersuche bis zum Knacken : ");


        do {
            for (int i = 0; i < test1.length; i++) {
                test1[i] = validInputs[randy.nextInt(validInputs.length)];
            }

            if (Arrays.equals(test1, password1)) {

                System.out.print(counter1 + "\n");
                counterP1++;
                save1 += counter1;
                history1.add(counter1)
                ;
                counter1 = 0;


                if (counterP1 == range && klick) {

                    mean1 = save1 / range;
                    System.out.println("Durchschnittliche Versuche bis zum knacken  : " + FG_MAGENTA + mean1 + RESET + "\n");
                    found1 = true;
                }

                if (counterP1 == 3 && !klick) {

                    mean1 = save1 / 3;
                    System.out.println("Durchschnittliche Versuche bis zum knacken  : " + FG_MAGENTA + mean1 + RESET + "\n");
                    found1 = true;
                }


            } else {
                counter1++;
            }
        } while (!found1 && Version1);


        // Force

        do {
            for (int i = 0; i < password2.length; i++) {
                password2[i] = validInputs[randy.nextInt(validInputs.length)];
            }
            System.out.println("Das Passwort ist : " + FG_MAGENTA + Arrays.toString(password2) + RESET + "\nVersuche bis zum Knacken : ");


            for (int i = 0; i < validInputs.length; i++) {
                for (int j = 0; j < validInputs.length; j++) {
                    for (int k = 0; k < validInputs.length; k++) {
                        for (int l = 0; l < validInputs.length; l++) {
                            for (int m = 0; m < validInputs.length; m++) {
                                for (int n = 0; n < validInputs.length; n++) {


                                    test2[0] = validInputs[i];
                                    test2[1] = validInputs[j];
                                    test2[2] = validInputs[k];
                                    test2[3] = validInputs[l];
                                    test2[4] = validInputs[m];
                                    test2[5] = validInputs[n];

                                    if (Arrays.equals(test2, password2)) {

                                        System.out.print(Versuche + "\n");
                                        richtigeVersuche++;
                                        Versucheaddiren += Versuche;
                                        history2.add(Versuche)
                                        ;
                                        Versuche = 0;


                                        if (richtigeVersuche == range && klick2) {

                                            mean2 = Versucheaddiren / range;
                                            System.out.println("Durchschnittliche Versuche bis zum knacken  : " + FG_MAGENTA + mean2 + RESET + "\n");
                                            found2 = true;
                                        }

                                        if (richtigeVersuche == 3 && !klick2) {

                                            mean2 = Versucheaddiren / 3;
                                            System.out.println("Durchschnittliche Versuche bis zum knacken  : " + FG_MAGENTA + mean2 + RESET + "\n");
                                            found2 = true;
                                        }


                                    } else {
                                        Versuche++;
                                    }

                                }//for n
                            }
                        }
                    }
                }
            }//for i

        } while (!found2 && Version2);


        // Compare

        int w, x, y, z, diff;
        diff = mean1 - mean2;

        //geht einfacher, bubble sort.!!!
        history1.sort(Comparator.naturalOrder());
        w = history1.getFirst();
        x = history1.getLast();
        history2.sort(Comparator.naturalOrder());
        y = history2.getFirst();
        z = history2.getLast();
        System.out.println("Minimum : " + w + "\nMaximum : " + x + "\nDurchschnitt von Rando : " + FG_MAGENTA + mean1 + RESET + "\n");
        System.out.println("Minimum : " + y + "\nMaximum : " + z + "\nDurchschnitt von Force : " + FG_MAGENTA + mean2 + RESET + "\n");

        if (mean1 < mean2) {
            System.out.println("Rando war um : " + FG_MAGENTA + diff + RESET + " Versuche im Durchschnitt schneller!");
        } else {
            System.out.println("Force war um : " + FG_MAGENTA + diff + RESET + " Versuche im Durchschnitt schneller!");
        }


    }//voidEnte
}
