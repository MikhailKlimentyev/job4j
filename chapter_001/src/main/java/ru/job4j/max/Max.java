package ru.job4j.max;

/**
 * Max of two numbers.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/25/2018
 */
public class Max {
    /**
     * max.
     * Compares two numbers and returns the biggest one.
     *
     * @param first Number.
     * @param second Number.
     * @return the biggest one of two numbers.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
