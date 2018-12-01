package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SquareTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/01/2018
 */
public class SquareTest {

    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound10ThenSquareFrom1To10() {
        int bound = 10;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound0ThenEmptyArray() {
        int bound = 0;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{};
        assertThat(rst, is(expect));
    }

    @Test(expected = NegativeArraySizeException.class)
    public void whenBoundNegativeNumberThenException() {
        int bound = -1;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{};
        assertThat(rst, is(expect));
    }
}
