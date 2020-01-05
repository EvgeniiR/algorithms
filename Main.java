import euclidean.EuclideanAlgorithm;
import sorting.QuickSort;
import sorting.SelectionSort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        EuclideanAlgorithm euclideanAlgorithm = new EuclideanAlgorithm();
        int greatestCommonDivisor = euclideanAlgorithm.findGreatestCommonDivisor(21, 8);
        System.out.println(greatestCommonDivisor);

        long start, end;
        start = System.nanoTime();
        Integer[] unsorted = initRandomNumbersArray(50000);
        SelectionSort selectionSort = new SelectionSort();
        Integer[] selectionSorted = selectionSort.sort(unsorted);
        end = System.nanoTime();
        System.out.println("Selection sort time = " + (end - start));
        System.out.println(Arrays.toString(selectionSorted));

        start = System.nanoTime();
        QuickSort quickSort = new QuickSort();
        Integer[] quickSorted = quickSort.sort(unsorted);
        end = System.nanoTime();
        System.out.println("Selection sort time = " + (end - start));
        System.out.println(Arrays.toString(quickSorted));
    }

    private static Integer[] initRandomNumbersArray(int length) {
        Integer[] array = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000000   );
        }
        return array;
    }
}
