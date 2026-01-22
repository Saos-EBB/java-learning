import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class kinoV2_testo {



    public static void main() {
        Random randy = new Random();
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> chosenMoviesArrL = new ArrayList<>();

        int menuChoice, seatsLeft, ticketChoice, movieChoice, movieChoiceIndex, movieChoice2;
        float userBudget, change;

        boolean keepRunning = true, keep1Running = true, keep2Running = false, keep3Running = false;

        String seatsLeftString, infoFormat;
        String[][] arr2Movies = {
                {"1", "Black Phone 2", "21:00", "1", "13.50", "25"},
                {"2", "Bogonia ", "20:00", "2", "13.50", "25"},
                {"3", "Chainsaw Men", "23:00", "3", "16.30", "25"},
                {"4", "Dracula", "00:30", "4", "14.70", "25"},
                {"5", "Good Boy", "02:00", "5", "13.50", "25"},
                {"6", "One Piece", "20:15", "6", "13.20", "25"}
        };


        //fertig
        do {
            System.out.println(FG_BRIGHT_CYAN + "Hallo!");
            System.out.println("Wie hoch ist dein Budget? " + RESET);
            System.out.println(FG_RED + "0 = MainMenu" + RESET);
            userBudget = scan.nextInt();
            if (userBudget == 0) {
                keepRunning = false;

            } else if (userBudget < 0) {
                System.out.println(FG_RED + "Keine Minus Eingabe" + RESET);
                keepRunning = false;


            } else if (userBudget <= 14) {
                System.out.println(FG_RED + "NO MONEY NO MOVIE !" + RESET);
            } else {
                System.out.println(FG_GREEN + "Dein Budget ist :" + userBudget + "€" + RESET);
            }
        } while (userBudget <= 14 && keepRunning);


        do {// fast fertig -

            System.out.println(FG_BRIGHT_CYAN + "Was willst du als nächstes tun ?  \n" +
                    "1. Ticket Kaufen \n" +
                    "2. Film Ansehen \n" +
                    "3. Gewinnspiel \n" +
                    "4. Kino Verlassen");

            menuChoice = scan.nextInt();


            switch (menuChoice) {

                // back to menu ?????
                case 1:
                    do { // KinoV1 copy paste mit bissi umschreiben.
                        infoFormat = "%-5s  %-17s %8s %6s %8s %20s \n";
                        System.out.printf(FG_BRIGHT_CYAN + infoFormat, "Nr", "FilmName", "UhrZeit", "Saal", "Preis €", "Plätze" + RESET);
                        System.out.println(FG_MAGENTA + "*".repeat(70) + RESET);
                        for (int i = 0; i < arr2Movies.length; i++) {
                            System.out.printf(FG_BRIGHT_CYAN + infoFormat, arr2Movies[i][0], arr2Movies[i][1], arr2Movies[i][2], arr2Movies[i][3], arr2Movies[i][4], arr2Movies[i][5] + RESET);
                        }
                        System.out.println(FG_MAGENTA + "*".repeat(70) + RESET);

                        System.out.println(FG_BRIGHT_CYAN + "Für welchen Film willst du Tickets kaufen? \nBitte Film Nummer Eingeben ! \n" + FG_RED + " 0 = MainMenu" + RESET);
                        movieChoice = scan.nextInt();
                        movieChoiceIndex = movieChoice - 1;

                        if (movieChoice == 0) {
                            System.out.println(FG_RED + "back to Main");
                            keep1Running = false;
                        } else if (movieChoice >= 1 && movieChoice <= arr2Movies.length) {  // richtige eingabe
                            System.out.printf(FG_BRIGHT_CYAN + infoFormat, "Nr", "FilmName", "UhrZeit", "Saal", "Preis €", "Plätze" + RESET);
                            System.out.println(FG_MAGENTA + "*".repeat(70) + RESET);
                            System.out.printf(FG_BRIGHT_CYAN + infoFormat, arr2Movies[movieChoiceIndex][0], arr2Movies[movieChoiceIndex][1], arr2Movies[movieChoiceIndex][2], arr2Movies[movieChoiceIndex][3], arr2Movies[movieChoiceIndex][4], arr2Movies[movieChoiceIndex][5] + RESET);
                            System.out.println(FG_MAGENTA + "*".repeat(70) + RESET);
                            System.out.println(FG_BRIGHT_CYAN + "Wie viele Tickets möchtest du ? ");
                            ticketChoice = scan.nextInt();

                            if (ticketChoice <= 0) {
                                System.out.println(FG_RED + "keine 0  & keine Minuszahl ! " + RESET);
                            } else {// Richtig
                                seatsLeftString = arr2Movies[movieChoiceIndex][5];
                                seatsLeft = Integer.parseInt(seatsLeftString);


                            if (ticketChoice > seatsLeft) {
                                    System.out.println(FG_RED + "Bitte genau schaun! ");
                                    System.out.println("Nicht genügend tickets verfügbar!" + RESET);

                                } else { // wenn alles passt
                                    seatsLeft = seatsLeft - ticketChoice;
                                    float preis = Float.parseFloat(arr2Movies[movieChoiceIndex][4]);
                                    change = userBudget - (ticketChoice * preis);


                                    if (change < 0) {
                                        System.out.println(FG_RED + "Budget zu klein !" + RESET);

                                    } else { // Richtig
                                        System.out.println(FG_GREEN + "Tickets gekauft für: " + arr2Movies[movieChoiceIndex][1]);
                                        System.out.println("Dein Restgeld beträgt: " + change + "€" + RESET);
                                        arr2Movies[movieChoiceIndex][5] = String.valueOf(seatsLeft);
                                        userBudget = change;

                                        for (int i = 0; i < ticketChoice; i++) {
                                            chosenMoviesArrL.add(movieChoice);

                                        }
                                          if (seatsLeft == 0 ) {
                                              arr2Movies[movieChoiceIndex][5] = FG_RED + "ausgebucht" + RESET;
                                          }
                                        keep1Running = false;


                                    }
                                }
                            }
                        } else if (movieChoice > arr2Movies.length || movieChoice < 0) {
                            System.out.printf(FG_RED + "Bitte gültige Film Nummer Eingeben \n" + RESET);
                        }//elseEnte
                    }
                    while (keep1Running);

                    //Welchen Film schauen / ticket einlösen und aus list löschen.
                case 2:
                    if (menuChoice == 2) {
                        keep2Running = true;
                    }

                    while (!chosenMoviesArrL.isEmpty() && keep2Running) {
                        int ticketCase2;
                        String format = " %-5s Ticket für %-5s um  %-8s Uhr in Saal %-8s \n";

                        System.out.println(FG_BRIGHT_CYAN + "Für welchen Film willst du Tickets einlösen?");

                        chosenMoviesArrL.sort(Comparator.naturalOrder());

                        // Tickets Printen
                        System.out.println(FG_MAGENTA + "*".repeat(64) + RESET);
                        for (int j = 0; j < chosenMoviesArrL.size(); j++) {

                            int s = chosenMoviesArrL.get(j) - 1;


                            System.out.printf(FG_BRIGHT_CYAN + format, arr2Movies[s][0], arr2Movies[s][1], arr2Movies[s][2], arr2Movies[s][3] + RESET);

                            System.out.println(FG_MAGENTA + "*".repeat(64) + RESET);
                        }
                        movieChoice2 = scan.nextInt();
                        if (movieChoice2 == 0) {
                            System.out.println(FG_RED + "Back to Main!" + RESET);
                            keep2Running = false;
                            continue; // Continue statt else umd den rest für zurück springen
                        }


                        System.out.println(FG_BRIGHT_CYAN + "Wie viele Tickets willst du einlösen ?" + RESET);
                        ticketCase2 = scan.nextInt();
                        if (ticketCase2 == 0) {
                            System.out.println(FG_RED + "Back to Main!" + RESET);
                            keep2Running = false;
                        }

                        int ticketCounter = 0;

                        for (int x : chosenMoviesArrL) {
                            if (x == movieChoice2) {
                                ticketCounter++;
                            }
                        }

                        if (ticketCase2 > ticketCounter) {
                            System.out.println(FG_RED + "Nicht genügend Tickets im Besitz." + RESET);
                        } else {


                            //arr list bearbeiten
                            for (int i = 0; i < ticketCase2; i++) {
                                chosenMoviesArrL.remove(Integer.valueOf(movieChoice2));
                            }

                            // Chainsawmen <3
                            if (movieChoice2 == 3) {
                                System.out.print(CHAINSAW+"\n" );
                            }
                            //Rest
                            else {
                                System.out.println(FG_BRIGHT_CYAN + "Ticket/s wurde/n eingelöst.\nViel Spaß beim Film :) " + RESET);
                            }

                        }
                    }
                    keep2Running = false;


                    // gamble
                case 3:
                    if (menuChoice == 3) {
                        keep3Running = true;
                    }
                    while (keep3Running) {
                        int gambleInput;

                        System.out.println(FG_BRIGHT_CYAN + "Unser Gewinnspiel geht so:\n " + RESET + FG_MAGENTA + "Du würfelst eine Radom zahl zwischen 10 und 1000 und wenn die Quersumme > 16 ist gewinnst du. \n >16 = x2/ <16 = x0 \n Genau 16 x4!" + RESET);


                        int dice = randy.nextInt(990) + 10;
                        int sum = 0;

                        System.out.println(FG_BRIGHT_CYAN + "Wie viel willst du setzen?" + RESET);
                        gambleInput = scan.nextInt();
                        if (gambleInput > userBudget) {
                            System.out.println(FG_RED + "Nicht genug Budget!" + RESET);
                        } else if (gambleInput == 0) {
                            keep3Running = false;
                            System.out.println(FG_RED + "Back to Main!");
                        } else { // genug Budget

                            System.out.print(FG_MAGENTA + dice + RESET);
                            while (dice > 0) {
                                int s = dice % 10;
                                sum += s;
                                dice = dice / 10;

                            }

                            System.out.print(FG_BRIGHT_CYAN + " die Quersumme daraus ist  " + RESET + FG_MAGENTA + sum + RESET);

                            if (sum < 16) {
                                System.out.println(FG_RED + "  \n" +
                                        "                $$ |                        $$ |          $$ |      \n" +
                                        "$$\\   $$\\     $$ | $$$$$$\\   $$$$$$$\\ $$$$$$\\        $$ |      \n" +
                                        "$$ |  $$ |      $$ |$$  __$$\\ $$  _____|\\_$$  _|        $$ |      \n" +
                                        "$$ |  $$ |      $$ |$$ /  $$ |\\$$$$$$\\    $$ |          \\__|      \n" +
                                        "$$ |  $$ |      $$ |$$ |  $$ | \\____$$\\   $$ |$$\\                 \n" +
                                        "\\$$$$$$  |      $$ |\\$$$$$$  |$$$$$$$  |  \\$$$$  |    $$\\       \n" +
                                        " \\______/       \\__| \\______/ \\_______/    \\____/      \\__|      \n" +
                                        "                                                                  \n" +
                                        "                                                                  \n" +
                                        "                                                                  " + RESET);
                                userBudget = userBudget - gambleInput;
                                System.out.println(FG_GREEN + "Dein Budget bertägt jetzt : " + userBudget + "€" + RESET);
                            } else if (sum > 16) {
                                System.out.print(FG_GREEN + "                                                        \n" +
                                        "                                                        \n" +
                                        "$$\\   $$\\       $$\\  $$\\  $$\\  $$$$$$\\  $$$$$$$\\        \n" +
                                        "$$ |  $$ |      $$ | $$ | $$ |$$  __$$\\ $$  __$$\\       \n" +
                                        "$$ |  $$ |      $$ | $$ | $$ |$$ /  $$ |$$ |  $$ |      \n" +
                                        "$$ |  $$ |      $$ | $$ | $$ |$$ |  $$ |$$ |  $$ |      \n" +
                                        "\\$$$$$$  |      \\$$$$$\\$$$$  |\\$$$$$$  |$$ |  $$ |      \n" +
                                        " \\______/        \\_____\\____/  \\______/ \\__|  \\__|      \n" +
                                        "                                                        \n" +
                                        "                                                        \n" +
                                        "                                                        ");
                                userBudget = userBudget + (gambleInput * 2);
                                System.out.println("\nDein Budget bertägt jetzt : " + userBudget + "€" + RESET);
                            } else {
                                System.out.print(FG_GREEN +
                                        "\n" +
                                        "$$\\       $$\\                               $$\\\n" +
                                        "$$ |      \\__|                              \\__|\n" +
                                        "$$$$$$$\\  $$\\  $$$$$$\\        $$\\  $$\\  $$\\ $$\\ $$$$$$$\\\n" +
                                        "$$  __$$\\ $$ |$$  __$$\\       $$ | $$ | $$ |$$ |$$  __$$\\\n" +
                                        "$$ |  $$ |$$ |$$ /  $$ |      $$ | $$ | $$ |$$ |$$ |  $$ |\n" +
                                        "$$ |  $$ |$$ |$$ |  $$ |      $$ | $$ | $$ |$$ |$$ |  $$ |\n" +
                                        "$$$$$$$  |$$ |\\$$$$$$$ |      \\$$$$$\\$$$$  |$$ |$$ |  $$ |\n" +
                                        "        \\_____\\__| _$$ |       \\_____\\____/ \\__|\\__|  \\__|\n" +
                                        "             $$\\    $$ |\n" +
                                        "               \\$$$$$$  |\n" +
                                        "               \\______/  ");
                                userBudget = userBudget + (gambleInput * 4);
                                System.out.println("\nDein Budget bertägt jetzt : " + userBudget + "€" + RESET);
                            }

                        }//richtig else Ente
                    }


                    // Kino verlassen
                case 4:
                    if (menuChoice == 4) {

                        System.out.println("Danke für Ihren Besuch bei ");
                        System.out.println("""
                                ┌─┐┌─┐┌─┐┌─┐
                                └─┐├─┤│ │└─┐
                                └─┘┴ ┴│ │└─┘..43
                                      └─┘  \s
                                """);
                        keepRunning = false;

                    }


            }//switchEnte}
        } while (keepRunning);

    }//void 1 Ente


    //Graphic Stuff
    public static final String FG_BRIGHT_CYAN = "\u001B[96m"; // Helles Cyan
    public static final String FG_MAGENTA = "\u001B[35m"; // Magentafarbener Text
    public static final String RESET = "\u001B[0m";
    public static final String FG_GREEN = "\u001B[32m"; // Grüner Text
    public static final String FG_RED = "\u001B[31m"; // Roter Text
    public static final String CHAINSAW = """
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=.@@@@%+@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*...::.:@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-. :-=====-:-@: @@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@# :=+.-=-=#%%%#=--.:@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ :==-*%%%%%%%%+--=@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.  ---+%%%%%%%%%%%*--.=+@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@: .*% :=--#%%%%%%%%%%%%%:-:-@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%+ :-=-+%%%%%%%%%%%%%#-:-.@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@:                   ...     :=--#%%%%%%%%%%%%%+:-=.:-:.@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@. .....................::------:-=%%%%%%%%%%%#-:-::@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@ .................-================:*%%%%%%+:--:--:-@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@- ... .@@@@@@.:::::::::==============:#%#---..-@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@ .....@@@%..-===========::===========:.--..-=-.*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@# ...  . -=====+++++======-:==========.::-=.@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@......   .=.      .  .=====:-========:====-*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@ ..... ..-::-====-:-  .====:==+-..   .-===-@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@:      ...=-  -@@#+-=:   -=:.            -==@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@* .  ....:==-.-===:*@.--       *@@#%@@@    #@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@- ... .. -===  #%@+-:     =@@@@@@@@@@@@@% %@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@- ......... ====-.--    -@@@@@@@#@@@@*@@@@+@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@+     .  . . :== ..   +@@@@@@*@@@ :@@% @% @#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@-     .  .  .:===.-.::@@@:@@@ *@@  +@= #= -@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@.      .  .   -: . :.:  @@  @@  -@   *    .=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@*          .    .:  .:::  @.  %            #@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@%....... ..   .  .:  : .                 . @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@#::      .   .. .. . -         %   @  +@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@#.#*: @@@@@*  .:  ..       .:.. -  %@ :@# #@@ @@#%@@@@@@@@@@@@@@@@ =@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@%@%.----:=@@@@@@@@@-   ...   -.: . @@.@@%%@@%@@@@@@@-@@@@@@@@@@@@.:::----  +@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@ :-=#%#--::@@@@@@@@-.    ... :. - @@@@@@@@@+@@@:+%= -.@@@@@@@%@@.--=#%#=-:@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@:-+%%%%*--.  #@@@@@...     . -:   .......:::::----=--.@@@@@@- .--#%%%%=-..@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@- .-.#%%%%*-- -@@%+@@: .....  .==-:::::-=============:-+-#@@-.=-*%%%%#.-.@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@.:-=%%%%#-+@@@@=@@@:   ....==============-::::::::::  @@@@++%%%%%--:..@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@:-:+%%%-@@@@@-@@@@@@@%.*@=.    ....:::..-+:@@@@@@@@=@@@@@+%%%=::.@@=@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@:..-:#%**@@@@.-@@@@+*@@@@@@@%%@: =@%@@@@@@@@**@@@@ :@@@@*#%*:-:+ @@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@-:-=%+@@@@:: .=@@%@@@@@@@@@@- +@@@@@@@@@@*@@-. -:@@@%*%--: @@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@*#%--:=+#@@@#..:@@@#@+@@@@@@@- %@@@@@@@*@#@@%+..#@@@*+=::=@=+@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@:.-:*=@@@@@@*@@@@#@@@@@@@- =@@@@@@@*@@@@=@@@@@@+*:-. %@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@#---*=*@@@*@@@.%@@@@@@@#  @@@@@@@+:@@@*@@@*+*--.:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@%  -:=**.  =+%+@@@@@@@@% .:@@@@@@###=: ..**-::+@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@-.:::.:@@@=@@@@@@@@@-..-@@@@@@*@@@@*.:::.:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@:@@@@@@@@#@@@@@@@@@*+:.@@@@@@*@@@@@.%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-*@@@@@@@+:+%@#@@@%==@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@. ...  ..++-..  ... .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    ......   ......    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ..........   .......... @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:............ :.......... =@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@* .........-@@@@%:......... @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ........ @@@@@@@@* ....... .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@* ........@@@@@@@@@@%........ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:@#..:-+:@@@@@@@@@@@@*++-:.:#%-@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:=#%=*@@%%+@@@@@@@@@@@@@-%#@@++%*+-@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@**@@@##%%%+@@@@@@@@@@@@@@@*#@%%%@@@=%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@+-==-=#@@@@@@@@@@@@@@@@@@@#--==-*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        =@@@+=  :@@@@.#+=@@@@@@@@@@@=-@@@@@@@@@@@@@@@@@@@@@@@@@%*@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@+
                         +@@@@@@@@@@@@@@@@@@@@@@@@@@@%#=@@@@@@@@@%#@@@@@@%:+@=@%*@@@@@@*.:@@@@@██@@#@@██▓@@@@@@@@@@#██@%=@@@█*
                         ▄████▄ @@██░ ██  ▄▄▄ @@@@  ██▓ ███▄ @@ █ @ ██████  ▄▄▄ @@@@  █ @@@ █░ ███▄ ▄███▓ ▄▄▄ @@@@@ ███▄ @@ █\s
                        ▒██▀ ▀█  ▓██░ ██▒▒████▄ @@ ▓██▒ ██ ▀█   █ ▒██    ▒ ▒████▄ @@ ▓█░ █ ░█░▓██▒▀█▀ ██▒▒████▄ @@@ ██ ▀█   █\s
                        ▒▓█    ▄ ▒██▀▀██░▒██  ▀█▄  ▒██▒▓██  ▀█ ██▒░ ▓██▄   ▒██  ▀█▄  ▒█░ █ ░█ ▓██    ▓██░▒██  ▀█▄  ▓██  ▀█ ██▒
                        ▒▓▓▄ ▄██▒░▓█ ░██ ░██▄▄▄▄██ ░██░▓██▒  ▐▌██▒  ▒   ██▒░██▄▄▄▄██ ░█░ █ ░█ ▒██    ▒██ ░███▄▄▄▄██ ▓██▒  ▐▌██▒
                        ▒ ▓███▀ ░░▓█▒░██▓ ▓█   ▓██▒░██░▒██░   ▓██░▒██████▒▒ ▓█   ▓██▒░░██▒██▓ ▒██▒   ░██▒ ▓█   ▓██▒▒██░   ▓██░
                        ░ ░▒ ▒  ░ ▒ ░░▒░▒ ▒▒   ▓▒█░░▓  ░ ▒░   ▒ ▒ ▒ ▒▓▒ ▒ ░ ▒▒   ▓▒█░░ ▓░▒ ▒  ░ ▒░   ░  ░ ▒▒   ▓▒█░░ ▒░   ▒ ▒\s
                          ░  ▒    ▒ ░▒░ ░  ▒   ▒▒ ░ ▒ ░░ ░░   ░ ▒░░ ░▒  ░ ░  ▒   ▒▒ ░  ▒ ░ ░  ░  ░      ░  ▒   ▒▒ ░░ ░░   ░ ▒░
                        ░         ░  ░░ ░  ░   ▒    ▒ ░   ░   ░ ░ ░  ░  ░    ░   ▒     ░   ░  ░      ░     ░   ▒      ░   ░ ░\s
                        ░ ░       ░  ░  ░      ░  ░ ░           ░       ░        ░  ░    ░           ░         ░  ░         ░\s
                        ░                                                                                                \s""";


}//classEnte





