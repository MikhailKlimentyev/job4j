package ru.job4j.array;

/**
 * Turn.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/01/2018
 */
public class Turn {

    /**
     * back.
     * <p>
     * Method gets array and returns turned array.
     *
     * @param array array.
     * @return turned array.
     */
    public int[] back(int[] array) {
        for (int index = 0; index != array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}
