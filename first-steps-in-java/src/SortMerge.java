import java.util.Arrays;

public class SortMerge {

    public static void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        // Kopiere Teilstücke in temporäre Arrays
        int[] leftPart = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightPart = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        // Zusammenführen (Merge)
        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                array[k++] = leftPart[i++];
            } else {
                array[k++] = rightPart[j++];
            }
        }

        // Restliche Elemente kopieren
        while (i < leftPart.length) array[k++] = leftPart[i++];
        while (j < rightPart.length) array[k++] = rightPart[j++];
    }

    public static void main(String[] args) {
        int[] data = {38, 27, 43, 10, 3, 9, 82, 10};

        sort(data);

        System.out.println("Sorted Array: " + Arrays.toString(data));
    }
}

