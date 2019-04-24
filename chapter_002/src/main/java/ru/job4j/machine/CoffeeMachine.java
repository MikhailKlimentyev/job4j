package ru.job4j.machine;

/**
 * Coffee Machine entity.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 04 /24/2019
 */
public class CoffeeMachine {
    /**
     * Coins.
     */
    private static final int[] COINS = {1, 2, 5, 10};

    /**
     * Changes int [ ].
     *
     * @param value the value
     * @param price the price
     * @return the int [ ]
     */
    public int[] changes(int value, int price) {
        if (value <= 0 || price < 0) {
            int[] resultArray = {0};
            return resultArray;
        }
        int diff = value - price;
        int[] initialArray = new int[100];
        int count;
        for (count = 0; diff > 0; count++) {
            if (COINS[3] <= diff) {
                diff -= COINS[3];
                initialArray[count] = COINS[3];
            } else if (COINS[2] <= diff) {
                diff -= COINS[2];
                initialArray[count] = COINS[2];
            } else if (COINS[1] <= diff) {
                diff -= COINS[1];
                initialArray[count] = COINS[1];
            } else {
                diff -= COINS[0];
                initialArray[count] = COINS[0];
            }
        }
        int[] resultArray = new int[count];
        System.arraycopy(initialArray, 0, resultArray, 0, count);
        return resultArray;
    }
}
