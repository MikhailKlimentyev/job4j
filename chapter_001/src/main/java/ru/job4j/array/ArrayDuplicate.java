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
        int unique = array.length;
        for (int outer = 0; outer < unique; outer++) {
            for (int inner = outer + 1; inner < unique; inner++) {
                if (array[outer].equals(array[inner])) {
                    array[inner] = array[unique - 1];
                    unique--;
                    inner--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }

}
