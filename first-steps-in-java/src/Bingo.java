import java.util.ArrayList;
import java.util.Random;

public class Bingo {
    static void main(String[] args) {
        ArrayList<Integer> history = new ArrayList<>();
        int[][] card = createCard(history);
        Print(card);
        boolean verify = verifyCard(card, history);


    }//mainEnte

    // 1. OnlyFills
    static int[][] createCard(ArrayList<Integer> history) {
        Random randy = new Random();
        int[][] card = new int[5][5];

        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {

                card[i][j] = (i * 15) + randy.nextInt(15) + 1;
                while (history.contains(card[i][j])) {
                    card[i][j] = (i * 15) + randy.nextInt(15) + 1;
                }
                history.add(card[i][j]);
                card[card.length / 2][card[i].length / 2] = 0;

            }
        }
        return card;
    }


    // 2. OnlyPrint
    static void Print(int[][] card) {
        System.out.println("  B    I    N    G    O ");
        for (int j = 0; j < card.length; j++) {
            System.out.println("+----+----+----+----+----+");

            System.out.printf("| %2s | %2s | %2s | %2s | %2s |\n"
                    , card[0][j]
                    , card[1][j]
                    , card[2][j] == 0 ? "**" : card[2][j]
                    , card[3][j]
                    , card[4][j]);
        }
        System.out.println("+----+----+----+----+    |");


    }

    static boolean verifyCard(int[][] card, ArrayList<Integer> history) {

        int[][] test = new int[5][5];
        boolean verify = true;

        ArrayList<Integer> testlist = new ArrayList<>();


        for (int i = 1; i <= 75; i++) {
            testlist.add(i);
        }

        // Größe
        for (int i = 0; i < test.length; i++) {
            if (card.length != test.length || card[i].length != test[i].length) {
                verify = false;
            }

        }
        // Doppel
        for (int h : history) {
            int index = h -1;
            if (testlist.get(index) == 0) {
                verify = false;
            } else {
                testlist.set(index, 0);
            }
        }
        // Mitte
        for (int i = 0; i < card.length; i++) {
            if (card[card.length / 2][card[i].length / 2] != 0) {
                verify = false;
            }
        }
        System.out.println("Verifyed : " + FG_YELLOW + verify + RESET);
        return verify;
    }

    public static final String FG_YELLOW = "\u001B[33m";
    static final String RESET = "\u001B[0m";


}//quack

