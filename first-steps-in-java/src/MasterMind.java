import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {

    static void main(String[] args) {
        int[][] map = new int[11][6];


        int round = 0;
        boolean win = false;

        //int [] secret = {1,2,3,7}  // troll
        int[] secret = createSecret();

        while (!win && round < 10) {
            int[] guess = readUserInput();


            int[] pins = evaluate(guess, secret);
            map[round][4] = pins[0];
            map[round][5] = pins[1];


            for (int i = 0; i < 4; i++) {
                map[round][i] = guess[i];
            }

            if (Arrays.equals(guess, secret)) {
                for (int i = 0; i < secret.length; i++) {
                    map[10][i] = secret[i];
                }
            }
            if (round == 9) {
                for (int i = 0; i < secret.length; i++) {
                    map[10][i] = secret[i];
                }
            }

            print(map, round, guess, secret);

            if (Arrays.equals(guess, secret)) {
                win = true;
            }

            round++;
        }

        //win / lose
        System.out.println(win ? "Gewonnen !! \n " : "Verloren :( \n" + troll );
    }//mainEnte

    //1. evaluieren
    static int[] evaluate(int[] guess, int[] secret) {
        int[] guessCopy = Arrays.copyOf(guess, guess.length);
        int[] secretCopy = Arrays.copyOf(secret, secret.length);

        int black = 0, white = 0;


        //BLACK PINS
        for (int i = 0; i < guess.length; i++) {
            if (guessCopy[i] == 0) {
                continue;
            }

            if (guessCopy[i] == secretCopy[i]) {
                black++;
                guessCopy[i] = 0;
                secretCopy[i] = 0;
            }
        }

        //WHITE PINS
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < guess.length; j++) {
                if (guessCopy[i] == 0) {
                    continue;
                }
                if (guessCopy[i] == secretCopy[j]) {
                    white++;
                    guessCopy[i] = 7;
                    secretCopy[j] = 0;
                }
            }
        }

        return new int[]{black, white};
    }

    //2. createSekret
    static int[] createSecret() {
        Random randy = new Random(0); // 1526 wenn 0
        int[] secret = new int[4];
        for (int i = 0; i < secret.length; i++) {


            secret[i] = randy.nextInt(6) + 1;
        }
        return secret;
    }

    //3. Read UserInput
    static int[] readUserInput() {

        Scanner scan = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.println("Gib 4 Zahlen (1-6) ein.");
            userInput = scan.next();
            if (userInput.matches("[1-6]{4}")) {
                break;
            } else {
                System.out.println("Wrong input bro, nur zwischen 1 - 6. ");
            }
        }
        int[] guess = new int[4];
        for (int i = 0; i < guess.length; i++) {
            guess[i] = userInput.charAt(i) - '0';
        }
        System.out.println();
        return guess;
    }


    // 4. 1  print + color
    static void print(int[][] map, int round, int[] guess, int[] secret) {

        for (int i = 0; i < map.length; i++) {
            System.out.println("+---+---+---+---+------+");

            //Pins-String
            String pins = "", g1, g2, g3, g4;
            for (int j = 0; j < map[i][4]; j++) pins += "#";
            for (int j = 0; j < map[i][5]; j++) pins += "+";

            if (round == 9) {
                pins = color(1) + "LOSE" + RESET;
            }
            if (Arrays.equals(guess, secret)) {
                pins = color(3) + "WON!" + RESET;
            }

            if (i == map.length - 1 && !Arrays.equals(guess, secret) && round != 9) {
                g1 = g2 = g3 = g4 = CYAN +"X" +RESET;
            } else {
                // strings für farben die checken nur "Zeichenketten" !!!  + ternary if else für null replace
                g1 = color(map[i][0]) + (map[i][0] == 0 ? " " : map[i][0]) + RESET;
                g2 = color(map[i][1]) + (map[i][1] == 0 ? " " : map[i][1]) + RESET;
                g3 = color(map[i][2]) + (map[i][2] == 0 ? " " : map[i][2]) + RESET;
                g4 = color(map[i][3]) + (map[i][3] == 0 ? " " : map[i][3]) + RESET;
            }

            System.out.printf("| %s | %s | %s | %s | %-4s |\n", g1, g2, g3, g4, pins);
        }
        System.out.println("+---+---+---+---+------+");


    }

    //cheat code , Platzhalter in methoden <3
    static String color(int PLATZHALTER) {
        return switch (PLATZHALTER) {
            case 1 -> RED;
            case 2 -> YELLOW;
            case 3 -> GREEN;
            case 4 -> BLUE;
            case 5 -> PURPLE;
            case 6 -> CYAN;
            case 7 -> BRIGHT_WHITE;
            default -> RESET;
        };
    }

    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String YELLOW = "\u001B[33m";
    static final String GREEN = "\u001B[32m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BRIGHT_WHITE = "\u001B[97m";
    static final String troll = """ 
%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@@@@@@@@#*=-:.............::::::::-------::::....:#@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@%+:......:+*****+++++***#%@@@@@@%*++#@@@@@@@@@@@*..+@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@#-..=#%##%%@@@@@@@@@@@@@%#**********#%@@@%**%@@@@@@@@#.:#@@@@@@@@@@@@@@@@%
%@@@@@@@@@%+.:+%@@@@@@@@@@@@@@@@@@@@@@@@@@%####%%%%%%#**%@#*%@@@@@@%=.+@@@@@@@@@@@@@@@%
%@@@@@@@@*:-#@@@@@@@#*#########%@@@@@@@@@@+@@@@@@@%%%#**##*%%%*@@@@@@+.+@@@@@@@@@@@@@@%
%@@@@@@@%--#@@@@@@*#@@@@@@@@@@%@@@@@@@@@@+@@@@@@@@@@@@@@#*##*%@%@@@@@@+.+@@@@@@@@@@@@@%
%@@@@@@@#:=@@@@@@%%@@@@@@@@@@%#@@@@@@@@@@@@@@@%#***##%@@@@%#@%@@@@@@@@@=.+@@@@@@@@@@@@%
%@@@@@@%-:*@@@@@@@@@%####%%@@@@@@@@@@@@@@@%+-.:-:.  ...:=*@@@@@@@@@@@@@%+.=%@@@@@@@@@@%
%@@@@%=.-%@@@@@@@@*:..:.. ..-*%@@@@@@@@@#-.=#@@%+.    .:-::#@@%%@@@@@@@%#=..+%@@@@@@@@%
%@@@*.:#%#*#####%@#=-::::...  .:=*%@@@@@:.*%*-..:-------:::*@@##@@@@@%##***=::*@@@@@@@%
%@@#.=%*###%@@@@@@@@@@@@@@@@*-..=%@@@@@@%=::-*@@@@#:=#@@@@@@@@%*-..:...-*@@%*+:-%@@@@%
%@@*:**@###-....:*@@@@@@@@@@@#:=@@@@@@@@@@@@@@@@@@@%=..:=++-...:*@@@@@@+.-%@%##::#@@@@%
%@@+.*#%#%*#@@@@+.....:@@@@@@+.+@@@@@@@@@@@@@@@@@@@@@@@@%%%@@@@@@%:.#@@@%--%@#%#:=@@@@%
%@@*.**%#@@@@%=*@@@@@@@@@@#:.-#@@@@@@@@@@+--*@*@@@@@@@@@@@@@@@*:.....+@@@*:*@#%@-:%@@@%
%@@#.-*@%*%@@=.-%@@@@@@@*:..*@@@@@@@@@@@@@%#.:@%%##*#%@@@%*-:.-*%@@...:=#+:#%#@#::%@@@%
%@@@+.=#*#@@*. .*@@@%+*##=-.:#@@@@@@*-:..:@%.:@@@@@@%+-:...:#@@@@@-.+@@@#:=@##@-.*@@@@%
%@@@@=.*@@%@=.:..-*@%@@@@@@%=:-+++%@@@@@@%@++%#*=-:.:=+#%+.*@@%+-..:%@@@@#%*##=.+@@@@@%
%@@@@%-:#@@%-..-=...:=*#@@@@@%*+*%@@@@%#++=:....+#%@@@@@*:.-=:.:..=@@@@@@%%#+:-#@@@@@@%
%@@@@@#:*@@%- .#+.#%*. ...:::--::::...:-=+*#%%::@@@@%*+:.  .=#%-.*@@@@@@@@*:.+%@@@@@@@%
%@@@@@#:+@@%- .+:.*@@.:@@@@%+.-#@@@%--%@@@@@@@+.=+-.. .:-:.#@#::%@@@@@@@@*:-#@@@@@@@@@%
%@@@@@#:+@@%-     .--.:+*###+.-####+::*###*=-..  ..:=*@@@+.+=.=@@@@@@@@@+.=@@@@@@@@@@@%
%@@@@@#:+@@%=.       LOSER HAHA            ..:::.+@@@@@@@%-.-#@@@@@@@@@+.=@@@@@@@@@@@@%
%@@@@@#:+@@@=.:. .   .          ........:+#@@@@#.-@@@@@%-.-#@@@@@@@@@@+.=@@@@@@@@@@@@@%
%@@@@@#:+@@@#:--.+=..+-. ......-*#%@@*.*@@@@@@@@+.+@%+..+%@@@@@@@@@@%:.*@@@@@@@@@@@@@@%
%@@@@@#:+@@@@#:.:*@+.+@%.:@@@*.+@@@@@#:*@@@@@@@@#:...-#@@@@@@@@@@@%:.=@@@@@@@@@@@@@@@@%
%@@@@@#.+@@@@@@*:.::..#@=.-@@%--%@@@@*:-@@#*=:...-*%@@@#*#@@#+%@*:.=%@@@@@@@@@@@@@@@@@%
%@@@@@#:*@@@@@@@@@%#*=--:...:....::::..:--=+##%@@@@#*#%@#*#%@#-.:*%@@@@@@@@@@@@@@@@@@@%
%@@@@@*:*@@@@@@%#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%**#%%#*#%%%+-.:+%@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@*:#@@%#@@@%#*#%@@@@@@@@@@@@@@@@@@%###########%%%*=::-*%@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@+:%@@@#*#%@@@@%#%##############**#######%@@%*=::-+#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@+:*@@@@@@#*#%%%%%%%%%%%########%@@@@@@@%#+:.-+%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@%-:*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#+:.-+#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@+.-*@@@@@@@@@@@@@@@@@@@@@%%#+=:...:+%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@%+:.:+%%@@@@@@@@%%#*=-...::=*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@%*+===------===+#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%
%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%

""";

                                                                    /*┌─┐┌─┐┌─┐┌─┐
                                                                      └─┐├─┤│ │└─┐
                                                                      └─┘┴ ┴│ │└─┘..43
                                                                            └─┘*/


}//classEnte


