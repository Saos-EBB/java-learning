import java.util.ArrayList;
import java.util.Random;

public class GameOfLife {
    public static void main(String[] args) {
        //einfach ne liste mit allen maps <3
        ArrayList<boolean[][]> history = new ArrayList<>();

        int ROWS = 30, COLS = 60;        // Stellschraube -> MapGröße
        int maxGenerations = 1000;       // Stellschraube -> Gens
        double aliveProbability = 0.09;  // Stellschraube -> Leben

        //1.Random Map erzeugen
        boolean[][] currentMap = createRandomMap(ROWS, COLS, aliveProbability);

        // Game of Life!
        int generation;
        for (generation = 0; generation < maxGenerations; generation++) {

            // 1a. save / copy  -  map
            history.add(currentMap);

            // 2. Print
            printMap(currentMap);

            // 3. Next gen & Regeln
            boolean[][] nextMap = nextGen(currentMap);

            // 4. Zyklus?
            int match = isRepeating(history,nextMap);
            if (match != -1) {

                System.out.println("Matching gen : " + match);
                break;
            }
            // 5. Update Map
            currentMap = nextMap;

            //Animation auf menschliche frames anpassen
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
        if (generation == maxGenerations) {
            System.out.println("No repeating pattern in : " + maxGenerations + " generations.");
        }

    }

    //1. Rando Map create
    static boolean[][] createRandomMap(int rows, int cols, double aliveProbability) {
        boolean[][] map = new boolean[rows][cols];
        Random rand = new Random(); // bei 0 immer 738 gen mit rowes: 30 , col: 60 und alive chance 0.09
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // wenn randy 1.0 unter 0.09 dann true und es lebt -> randy.nextDouble() wenn leer immer 1!!
                map[i][j] = rand.nextDouble() < aliveProbability;
            }
        }
        return map;
    }

    //2. Print
    static void printMap(boolean[][] map) {
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println("\n".repeat(40)); //ca eine "Seite" skippen
        System.out.print("┌");
        for (int i = 0; i < map[0].length; i++) System.out.print("─");
        System.out.println("┐");
        for (boolean[] row : map) {
            System.out.print("│");
            for (boolean cell : row) {
                System.out.print(cell ? GREEN + "█" + RESET : " ");
            }
            System.out.println("│");
        }
        System.out.print("└");
        for (int i = 0; i < map[0].length; i++) System.out.print("─");
        System.out.println("┘");
    }

    // 3. next Gen + Regeln & Neighbours
    static boolean[][] nextGen(boolean[][] map) {
        boolean[][] newMap = new boolean[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                int neighbors = countNeighbors(map, i, j);  // 3a
                newMap[i][j] = rules(map[i][j], neighbors); // 3b
            }
        }
        return newMap;
    }

    // 3a. Nachbarn zählen
    static int countNeighbors(boolean[][] map, int x, int y) {
        int count = 0, rows = map.length, cols = map[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;// ich prüf das 9 mal aber ich kann es auch ausserhalb machen, wie?
                //(index + size) % size  -> ist der trick
                int nx = (x + i + rows) % rows;
                int ny = (y + j + cols) % cols;

                if (map[nx][ny]) count++;
            }
        }
        return count;
    }


    // 3b. Conway-Regeln
    static boolean rules(boolean alive, int count) {
        return count == 3 || alive && count == 2; // Matrin is keeping me humble
    }

    // 4 . Besser - be efficent
    static int isRepeating(ArrayList<boolean[][]> history, boolean[][] current) {
        for (int gen = 0; gen < history.size(); gen++) {
            boolean[][] oldMap = history.get(gen);
            boolean equal = true;
            for (int i = 0; i < current.length && equal; i++) {
                for (int j = 0; j < current[i].length; j++) {
                    if (current[i][j] != oldMap[i][j]) {
                        equal = false;
                        break;
                    }
                }
            }
            if (equal) return gen;
        }
        return -1;
    }


}
