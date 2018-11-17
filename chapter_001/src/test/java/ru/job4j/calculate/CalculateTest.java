package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CalculateTest.
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 11/17/2018
 */
public class CalculateTest {
	/**
	 * Test echo.
	 */
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Mikhail Klimentyev";
		String expect = "Echo, echo, echo : Mikhail Klimentyev"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}