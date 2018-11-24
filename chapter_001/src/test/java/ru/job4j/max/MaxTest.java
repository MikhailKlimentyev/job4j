package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for Max class.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/25/2018
 */
public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstLargerSecond() {
        Max maxim = new Max();
        int result = maxim.max(3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstEqualSecond() {
        Max maxim = new Max();
        int result = maxim.max(0, 0);
        assertThat(result, is(0));
    }
}
