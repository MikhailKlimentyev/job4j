package ru.job4j.array;

/**
 * BubbleSort.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/02/2018
 */
public class BubbleSort {

    /**
     * sort.
     * <p>
     * sorts array by bubble way.
     *
     * @param array array.
     * @return sorted array.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
