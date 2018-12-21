package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayConcatTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/21/2018
 */
public class ArrayConcatTest {
    @Test
    public void whenTwoSortedAscendArraysThenThirdAscendArray() {
        ArrayConcat arrayConcat = new ArrayConcat();
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {-3, 0, 1, 1, 3};
        int[] expected = {-3, 0, 1, 1, 1, 2, 3, 3, 4, 5};
        int[] result = arrayConcat.concat(first, second);
        assertThat(result, is(expected));
    }
}
