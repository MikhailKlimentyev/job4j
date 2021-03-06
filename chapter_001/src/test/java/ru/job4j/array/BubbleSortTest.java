package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * BubbleSortTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/02/2018
 */
public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result =  bubbleSort.sort(array);
        int[] expected = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expected));
    }
}
