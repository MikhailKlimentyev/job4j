package ru.job4j.job;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * EngineerTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/24/2018
 */
public class EngineerTest {
    @Test
    public void whenInitializeProfessionFieldsThenEngineerFieldsGetSameValues() {
        String expectedName = "Ivan";
        String expectedSurname = "Ivanov";
        String expectedJob = "Enginner";
        Engineer engineer = new Engineer(expectedName, expectedSurname, expectedJob);
        String actualName = engineer.getName();
        String actualSurname = engineer.getSurname();
        String actualJob = engineer.getJob();
        assertThat(actualName, is(expectedName));
        assertThat(actualSurname, is(expectedSurname));
        assertThat(actualJob, is(expectedJob));
    }
}
