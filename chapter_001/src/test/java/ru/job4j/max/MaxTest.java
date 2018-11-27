package ru.job4j.max;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for Max class.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/25/2018
 */
@RunWith(DataProviderRunner.class)
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

    @Test
    @UseDataProvider("dataProviderForMaxFromThree")
    public void whenThreeNumbersThenMaxOfThemReturned(int a, int b, int c, int expected) {
        Max maxim = new Max();

        int result = maxim.max(a, b, c);
        assertThat(result, is(expected));
    }

    @DataProvider
    public static Object[][] dataProviderForMaxFromThree() {
        return new Object[][]{
                {3, 1, 2, 3},
                {1, 1, 4, 4},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 5, 5},
                {-1, 0, -5, 0}
        };
    }
}
