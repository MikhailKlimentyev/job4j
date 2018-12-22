package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * ThirdSortedArrayTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/22/2018
 */
public class ThirdSortedArrayTest {
    @Test
    public void whenTwoSortedAscendArraysThenThirdAscendArray() {
        ThirdSortedArray thirdSortedArray = new ThirdSortedArray();
        int[] first = {3, 7, 8, 9, 10};
        int[] second = {1, 3, 5, 7, 13};
        int[] expected = {1, 3, 3, 5, 7, 7, 8, 9, 10, 13};
        int[] result = thirdSortedArray.getArray(first, second);
        assertThat(result, is(expected));
    }
}
