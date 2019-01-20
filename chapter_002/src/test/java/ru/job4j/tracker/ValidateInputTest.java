package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ValidateInputTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/06/2019
 */
public class ValidateInputTest {
    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream out = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();

    /**
     * Метод устанавливает вывод в память.
     */
    @Before
    public void loadMem() {
        System.out.println("Execute before method.");
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Метод устанавливает вывод в консоль.
     */
    @After
    public void loadSys() {
        System.setOut(this.out);
        System.out.println("Execute after method.");
    }

    @Test
    public void whenValidInputThenThereIsNoMessage() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"0"})
        );
        int[] range = new int[7];
        range[0] = 0;
        input.ask("Please, select menu number: ", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("")
                )
        );
    }

    @Test
    public void whenInvalidInputThenAppropriateMessage() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"Invalid", "0"})
        );
        int[] range = new int[7];
        range[0] = 0;
        input.ask("Please, select menu number: ", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, enter number.%n")
                )
        );
    }

    @Test
    public void whenOutOfMenuRangeInputThenAppropriateMessage() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"1", "0"})
        );
        int[] range = new int[7];
        range[0] = 0;
        input.ask("Please, select menu number: ", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, enter number from menu.%n")
                )
        );
    }
}