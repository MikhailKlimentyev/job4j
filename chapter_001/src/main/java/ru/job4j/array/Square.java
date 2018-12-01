package ru.job4j.array;

/**
 * Square.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/01/2018
 */
public class Square {

    /**
     * calculate.
     * <p>
     * Method initializes array with squares of values from 1 to bound.
     *
     * @param bound array size.
     * @return initialized array.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int element = 1;
        for (int i = 0; i != bound; i++) {
            rst[i] = (int) Math.pow(element, 2);
            element++;
        }
        return rst;
    }
}
