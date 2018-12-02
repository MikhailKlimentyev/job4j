package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/02/2018
 */
public class ArrayDuplicate {

    /**
     * remove.
     * <p>
     * Gets array and returns cut array without duplicates.
     *
     * @param array array.
     * @return array without duplicates.
     */
    public String[] remove(String[] array) {
        int uniqueElements = array.length;
        for (int outer = 0; outer < uniqueElements; outer++) {
            for (int inner = outer + 1; inner < uniqueElements; inner++) {
                if (array[outer].equals(array[inner])) {
                    array[inner] = array[uniqueElements - 1];
                    uniqueElements--;
                    inner--;
                }
            }
        }
        return Arrays.copyOf(array, uniqueElements);
    }

}
