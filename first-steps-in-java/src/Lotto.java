import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lotto {
    static void main(String[] args) throws Exception {
        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> invalid = new ArrayList<>();

        //1. Datein von .txt   in eine Arrayliste Speichern;
        transferTxtToArray(data);

        //2. Zahlen ziehen;
        int[] draw = createNumbers();
        System.out.print("Ziehung : ");
        for (int p : draw) {
            System.out.print(p + " ");
        }
        System.out.println();

        //3. Validieren
        for (int i = 0; i < data.size(); i++) {
            if (!validate(data.get(i))) {
                invalid.add("" + getSerialnumber(data.get(i)));
                data.remove(i);
                i--;
            }
        }

        // 4.  Gleiche zählen  3 , 4, 5 & 6 ;
        int three = 0, four = 0, five = 0, six = 0;

        for (int i = 0; i < data.size(); i++) {
            int[] test = getTip(data.get(i));

            int counter = countEqualsBetter(test, draw);

            if (counter == 3) {
                three++;
            } else if (counter == 4) {
                four++;
            } else if (counter == 5) {
                five++;
            } else if (counter == 6) {
                six++;
            }

        }


        //5. Print die Ergebnisse
        System.out.println("\nGültige tips : " + data.size() + "\nUngültige Tips : " + invalid.size());
        System.out.print("\nGezogene Zahlen [ ");
        for (int p : draw) {
            System.out.print(p + "  ");
        }
        System.out.print("]\n");
        System.out.println("*".repeat(50));
        System.out.println(" 3er : " + three +
                "\n 4er : " + four +
                "\n 5er : " + five +
                "\n 6er : " + six);
        System.out.println("*".repeat(50));
        System.out.println("Ungültige : " + invalid);


    }

    //1. Daten einlesen
    public static void transferTxtToArray(ArrayList<String> data) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("lotto.txt"));
        String line ;
        while (br.ready()) {
            line = br.readLine();
            data.add(line);
        }
        br.close();
    }

    //2. Ziehung
    static int[] createNumbers() {
        ArrayList<Integer> history = new ArrayList<>();
        Random randy = new Random(0);
        int[] numb = new int[6];

        for (int i = 0; i < numb.length; i++) {

            int temp = randy.nextInt(45) + 1;

            if (!history.contains(temp)) {
                numb[i] = temp;
                history.add(numb[i]);
            } else {
                i--;
            }

        }
        Arrays.sort(numb);
        return numb;
    }

    // 3. Compare Draw and Tip
    static int countEquals(int[] tip, int[] draw) {
        int counter = 0;
        for (int i = 0; i < draw.length; i++) {
            for (int j = 0; j < tip.length; j++) {

                if (draw[i] == tip[j]) {
                    counter++;

                }
            }
        }
        return counter;
    }

    //FIX : 3.1 Compare more efficient
    static int countEqualsBetter(int[] tip, int[] draw) {
        int counter = 0;
        int i = 0, j = 0;

        while (i < tip.length && j < draw.length) {
            if (tip[i] == draw[j]) {
                counter++;
                i++;
                j++;
            } else if (tip[i] < draw[j]) {
                i++;
            } else {
                j++;
            }
        }
        return counter;
    }


    //4. Fehlersuche
    static boolean validate(String xxx) {
        char[] addUp = xxx.toCharArray();
        int sum = 0;
        for (int i = 0; i < addUp.length - 1; i++) {
            sum += addUp[i];
        }

            sum = sum % 10;

        //get Check
        char check = xxx.charAt(xxx.length() - 1);
        int chek = check - '0';
        if (chek != sum) {
            String temp = xxx.substring(0, 6);
            return false;
        }
        return true;
    }


    // Helper - get Tip
    static int[] getTip(String xxx) {
        String [] split = xxx.split(";"); // damit ich die zahlenpaare bekomme
        int[] tipInt = new int[6];

        for (int i = 1; i < tipInt.length + 1 ; i++) {
            tipInt[i -1] = Integer.parseInt(split[i]);
        }
        return tipInt;
    }

    //Helper - get Serial
    static int getSerialnumber(String xxx) {
        String temp = xxx.substring(0, 5);
        return Integer.valueOf(temp);
    }

    //Helper - get Check -> wurde in validate kopiert.
    static int getCheck(String xxx) {

        char tipChr = xxx.charAt(xxx.length() - 1);
        return tipChr - '0';
    }
}
