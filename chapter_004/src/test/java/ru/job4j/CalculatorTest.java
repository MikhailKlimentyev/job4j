package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

/**
 * 0. Функциональные итерфейсы тест.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 03/06/2019
 */
public class CalculatorTest {

    @Test
    public void whenMultiply1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value * index,
                result -> buffer.add(result)
        );
        Assert.assertThat(buffer, is(Arrays.asList(0D, 1D, 2D)));
    }
}
