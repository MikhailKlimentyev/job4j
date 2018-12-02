package ru.job4j.array;

/**
 * MatrixCheck.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/02/2018
 */
public class MatrixCheck {
    /**
     * mono.
     * <p>
     * If all of elements of matrix diagonal are equal then method returns true
     * <p>
     * Else returns false
     *
     * @param data boolean[][] matrix
     * @return result
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean temp;
        for (int i = 1; i < data.length - 1; i++) {
            for (int j = 1; j < data[i].length - 1; j++) {
                if (data[i][i] != data[i - 1][i - 1]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
