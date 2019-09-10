package ru.job4j.function;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 3 * x + 1);
        List<Double> expected = Arrays.asList(66D, 91D, 120D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(5, 8, x -> Math.log(x));
        List<Double> expected = Arrays.asList(1.6094379124341003D, 1.791759469228055D, 1.9459101490553132D);
        assertThat(result, is(expected));
    }
}
