package ru.job4j.exam;

import java.util.Arrays;

/**
 * ArrayConcat.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/21/2018
 */
public class ArrayConcat {
    /**
     * concat.
     *
     * @param first  first array.
     * @param second second array.
     * @return third array consisting of first and second arrays and sorted in ascend order
     */
    public int[] concat(int[] first, int[] second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        Arrays.sort(result);
        return result;
    }
}
