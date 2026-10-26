import java.util.HashSet;
import java.util.*;

public class Mengenlehre {
    // github url : https://gist.github.com/Saos-EBB/5af0e3cbe02079f4eabf58f2be0f4e01
    public static void main(String[] args) {

        int[] arrA = {1, 3, 5}, arrB = {3, 5, 7}, arrC = {5, 7, 9};
        Set<Integer> A = new HashSet<>(), B = new HashSet<>(), C = new HashSet<>();

        for (int x : arrA) A.add(x);
        for (int x : arrB) B.add(x);
        for (int x : arrC) C.add(x);

        System.out.println("VEREINIGUNGEN");
        System.out.println("A ∪ B = " + getUnion(A, B));
        System.out.println("A ∪ C = " + getUnion(A, C));
        System.out.println("B ∪ C = " + getUnion(B, C));

        System.out.println("\nSCHNITTMENGEN");
        System.out.println("A ∩ B = " + getIntersection(A, B));
        System.out.println("A ∩ C = " + getIntersection(A, C));
        System.out.println("B ∩ C = " + getIntersection(B, C));

        System.out.println("\nDIFFERENZEN");
        System.out.println("A \\ B = " + getDifference(A, B));
        System.out.println("A \\ C = " + getDifference(A, C));
        System.out.println("B \\ A = " + getDifference(B, A));
        System.out.println("B \\ C = " + getDifference(B, C));
        System.out.println("C \\ A = " + getDifference(C, A));
        System.out.println("C \\ B = " + getDifference(C, B));

        // verschachtelte methode
        System.out.println("\n===== UNION A ∪ B ∪ C =====");
        System.out.println("A ∪ B ∪ C = " + getUnion(A, getUnion(B, C)));


    }

    // VEREINIGUNG: A ∪ B
    // Duplikate werden automatisch ignoriert
    public static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);                        // vereinigen und duplikate skippen?
        return result;
    }

    // SCHNITTMENGE: A ∩ B
    // retainAll() entfernt alles, was NICHT in B ist.
    public static Set<Integer> getIntersection(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);                     // entferne alles aus a was nicht in b ist.
        return result;
    }

    // DIFFERENZ: A \ B
    // Kopie von A, entferne alle Elemente, die in B vorkommen.
    public static Set<Integer> getDifference(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.removeAll(b);                        // lösche alles aus a was in b ist.
        return result;
    }


}//Quack!




