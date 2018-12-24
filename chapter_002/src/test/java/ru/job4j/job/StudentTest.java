package ru.job4j.job;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StudentTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/24/2018
 */
public class StudentTest {
    @Test
    public void whenInitializeProfessionFieldsThenStudentFieldsGetSameValues() {
        String expectedName = "Ivan";
        String expectedSurname = "Ivanov";
        String expectedJob = "Enginner";
        Student student = new Student(expectedName, expectedSurname, expectedJob, 3);
        String actualName = student.getName();
        String actualSurname = student.getSurname();
        String actualJob = student.getJob();
        assertThat(actualName, is(expectedName));
        assertThat(actualSurname, is(expectedSurname));
        assertThat(actualJob, is(expectedJob));
    }
}
