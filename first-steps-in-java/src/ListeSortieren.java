import java.util.ArrayList;
import java.util.Random;

public class ListeSortieren {
    public static ArrayList<Integer> shuffleMe = new ArrayList<>();

    static void main(String[] args) {
        fillMeUp(shuffleMe);
        System.out.println(shuffleMe);
        bubbleSort(shuffleMe);
        System.out.println(shuffleMe);
    }

    public static void fillMeUp(ArrayList xxx) {
        Random randy = new Random();
        for (int i = 0; i <= 100; i++) xxx.add(randy.nextInt(10000) + 1);
    }

    public static void bubbleSort(ArrayList xxx) {
        boolean swapped = false;
        for (int i = 0; i < xxx.size() - 1 && !swapped; i++) {
            swapped = true;
            for (int j = 0; j < xxx.size() - 1; j++) {
                var x = (int) xxx.get(j);
                var y = (int) xxx.get(j + 1);
                if (x > y) {
                    int temp = x;
                    xxx.set(j, y);
                    xxx.set(j + 1, temp);
                    swapped = false;

                }
            }
        }

    }

}  //Quack!







