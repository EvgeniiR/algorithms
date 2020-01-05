package sorting;

/**
 * Selection sort
 * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection sort</a>
 */
public class SelectionSort implements Sort<Integer> {
    @Override
    public Integer[] sort(Integer[] array) {
        Integer[] arrayToSort = array.clone();
        for(int i = 0; i < arrayToSort.length; i++) {
            int smallestElementIndex = getSmallestElementIndex(arrayToSort, i);
            int smallestNumber = arrayToSort[smallestElementIndex];
            arrayToSort[smallestElementIndex] = arrayToSort[i];
            arrayToSort[i] = smallestNumber;
        }
        return arrayToSort;
    }

    private int getSmallestElementIndex(Integer[] elements, int startingIndex) {
        int smallestElementIndex = startingIndex;
        for(int j = startingIndex + 1; j < elements.length; j++) {
            if(elements[j] < elements[smallestElementIndex]) {
                smallestElementIndex = j;
            }
        }
        return smallestElementIndex;
    }
}
