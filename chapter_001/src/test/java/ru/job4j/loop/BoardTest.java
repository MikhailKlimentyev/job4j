package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * BoardTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/29/2018
 */
public class BoardTest {

    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String LINE = System.getProperty("line.separator");
        String expected = String.format("x x%s x %sx x%s", LINE, LINE, LINE);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String LINE = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x %s", LINE, LINE, LINE, LINE);
        assertThat(result, is(expected));
    }

}
