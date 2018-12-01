package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * CheckTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/01/2018
 */
public class CheckTest {

    @Test
    public void whenDataInOddArrayMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataInOddArrayNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataInEvenArrayMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataInEvenArrayNotMonoByFalseThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}
