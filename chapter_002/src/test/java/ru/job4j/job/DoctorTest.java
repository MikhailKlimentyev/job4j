package ru.job4j.job;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * DoctorTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/24/2018
 */
public class DoctorTest {
    @Test
    public void whenInitializeProfessionFieldsThenDoctorFieldsGetSameValues() {
        String expectedName = "Ivan";
        String expectedSurname = "Ivanov";
        String expectedJob = "Enginner";
        Doctor doctor = new Doctor(expectedName, expectedSurname, expectedJob);
        String actualName = doctor.getName();
        String actualSurname = doctor.getSurname();
        String actualJob = doctor.getJob();
        assertThat(actualName, is(expectedName));
        assertThat(actualSurname, is(expectedSurname));
        assertThat(actualJob, is(expectedJob));
    }
}
