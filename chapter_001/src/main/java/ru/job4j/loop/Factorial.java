package ru.job4j.loop;

/**
 * Factorial.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/29/2018
 */
public class Factorial {

    /**
     * calc.
     * <p>
     * Method gets number and returns factorial of this number.
     * <p>
     * If method gets zero, it returns 1.
     *
     * @param n number.
     * @return factorial.
     */
    public int calc(int n) {
        int result = 1;
        if (n == 0) {
            result = 1;
        }
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
