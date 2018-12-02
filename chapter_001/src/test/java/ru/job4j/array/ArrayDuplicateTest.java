package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayDuplicateTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/02/2018
 */
public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"Привет", "Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expected = {"Привет", "Мир", "Супер"};
        String[] result = arrayDuplicate.remove(array);
        assertThat(result, is(expected));
    }
}
