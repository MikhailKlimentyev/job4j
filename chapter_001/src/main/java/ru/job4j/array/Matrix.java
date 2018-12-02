package ru.job4j.array;

/**
 * Matrix.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/02/2018
 */
public class Matrix {

    /**
     * multiple.
     * <p>
     * Creates multiplication table of specified size.
     *
     * @param size matrix size.
     * @return multiplication table.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 1; j++) {
                table[i][j] = i + 1;
            }
        }

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = j + 1;
            }
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                table[i][j] = table[i][0] * table[0][j];
            }
        }

        return table;
    }
}
