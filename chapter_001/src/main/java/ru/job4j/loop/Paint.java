package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Paint.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/30/2018
 */
public class Paint {

    /**
     * rightTr.
     * <p>
     * Method creates right triangle.
     *
     * @param height height.
     * @return right triangle.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * leftTrl.
     * <p>
     * Method creates left triangle.
     *
     * @param height height.
     * @return left triangle.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * pyramid.
     * <p>
     * Method creates isosceles triangle.
     *
     * @param height height.
     * @return isosceles triangle.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * loopBy.
     * <p>
     * Method creates a triangle depending on the desired type of triangle.
     *
     * @param height  height.
     * @param width   width.
     * @param predict tick drawing condition.
     * @return triangle.
     */
    private String loopBy(int height, int width, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

}
