package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ConverterTest.
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/23/2018
 */
public class ConverterTest {
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(66);
        assertThat(result, is(1));
    }

    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(77);
        assertThat(result, is(1));
    }

    @Test
    public void when1DollarToRubleThen66() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(66));
    }

    @Test
    public void when1EuroToRubleThen74() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(74));
    }
}