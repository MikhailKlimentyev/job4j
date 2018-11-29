package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FactorialTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/29/2018
 */
public class FactorialTest {

    @Test
    public void when0Then1() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }

    @Test
    public void whenPositiveNumberThenFactorial() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }
}
