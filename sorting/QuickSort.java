package sorting;

/**
 * Quick sort implementation using loops instead of recursion
 * @see <a href="https://en.wikipedia.org/wiki/Quicksort">Quicksort</a>
 */
public class QuickSort implements Sort<Integer> {
    public Integer[] sort(Integer[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(array, startIndex, endIndex);
        return array;
    }

    private void doSort(Integer[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int i = startIndex, j = endIndex;
        int pivot = i - (i - j) / 2;
        while (i < j) {
            while (i < pivot && (array[i] <= array[pivot])) {
                i++;
            }
            while (j > pivot && (array[pivot] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == pivot)
                    pivot = j;
                else if (j == pivot)
                    pivot = i;
            }
        }
        doSort(array, startIndex, pivot);
        doSort(array,pivot+1, endIndex);
    }
}