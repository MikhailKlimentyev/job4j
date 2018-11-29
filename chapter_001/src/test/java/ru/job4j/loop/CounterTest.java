package ru.job4j.loop;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/29/2018
 */
@RunWith(DataProviderRunner.class)
public class CounterTest {

    @Test
    @UseDataProvider("dataProviderForSumOfEvenNumbers")
    public void whenTwoNumbersThenSumOfAllEvenNumbersBetweenTheseTwoNumbers(int startNumber, int finishNumber, int expected) {
        Counter counter = new Counter();
        int result = counter.add(startNumber, finishNumber);
        assertThat(result, is(expected));
    }

    @DataProvider
    public static Object[][] dataProviderForSumOfEvenNumbers() {
        return new Object[][]{
                {1, 3, 2},
                {-5, 10, 24},
                {0, 13, 42}
        };
    }
}
