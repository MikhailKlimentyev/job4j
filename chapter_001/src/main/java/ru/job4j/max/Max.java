package ru.job4j.max;

/**
 * Max.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/25/2018
 */
public class Max {
    /**
     * max.
     * <p>
     * Compares two numbers and returns the biggest one.
     *
     * @param first  Number.
     * @param second Number.
     * @return the biggest one of two numbers.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * max.
     * <p>
     * Compares three numbers and returns the biggest one.
     *
     * @param first number.
     * @param second number.
     * @param third number.
     * @return the biggest one of three numbers.
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return this.max(temp, third);
    }
}
