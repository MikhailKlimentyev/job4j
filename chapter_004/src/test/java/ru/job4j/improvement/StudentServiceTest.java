package ru.job4j.improvement;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * The type Student service test.
 */
public class StudentServiceTest {
    /**
     * T.
     */
    @Test
    public void whenStudentsAndBoundThenStudentsSortedDescendAndStudentsWithScopeMoreThanBound() {
        Student ivan = new Student("Ivan", 6);
        Student petr = new Student("Petr", 7);
        Student alex = new Student("Alex", 3);
        Student evgeniy = new Student("Evgeniy", 6);
        Student raul = new Student("Raul", 5);
        List<Student> students = Arrays.asList(ivan, petr, alex, evgeniy, raul);
        StudentService studentService = new StudentService();
        List<Student> resultStudents = studentService.levelOf(students, 3);
        List<Student> expectedStudents = Arrays.asList(petr, ivan, evgeniy, raul);
        assertThat(resultStudents, is(expectedStudents));
    }
}
