package ru.job4j.job;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TeacherTest.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/24/2018
 */
public class TeacherTest {
    @Test
    public void whenInitializeProfessionFieldsThenTeacherFieldsGetSameValues() {
        String expectedName = "Ivan";
        String expectedSurname = "Ivanov";
        String expectedJob = "Enginner";
        Teacher teacher = new Teacher(expectedName, expectedSurname, expectedJob);
        String actualName = teacher.getName();
        String actualSurname = teacher.getSurname();
        String actualJob = teacher.getJob();
        assertThat(actualName, is(expectedName));
        assertThat(actualSurname, is(expectedSurname));
        assertThat(actualJob, is(expectedJob));
    }
}
