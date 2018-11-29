package ru.job4j.loop;

/**
 * Counter.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/29/2018
 */
public class Counter {

    /**
     * add.
     * <p>
     * Method gets two numbers and returns sum of all even numbers between recevied numbers.
     *
     * @param start  start number
     * @param finish finish number
     * @return sum of all even numbers between recevied numbers.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
