package ru.job4j.array;

/**
 * Check.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/01/2018
 */
public class Check {

    /**
     * mono.
     * <p>
     * Method gets array and check if elements is equal ones
     *
     * @param data array.
     * @return result.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index != data.length - 1; index++) {
            if (data[index] == data[index + 1]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
