package ru.job4j.filter;


import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * The type School test.
 */
public class SchoolTest {
    /**
     * T.
     */
    @Test
    public void whenScoreFrom70To100Then10A() {
        School school = new School();
        Student student88 = new Student(88);
        Student student71 = new Student(71);
        Student student99 = new Student(99);
        Student student70 = new Student(70);
        Student student55 = new Student(55);
        Student student50 = new Student(50);
        Student student51 = new Student(51);
        Student student40 = new Student(40);
        Student student33 = new Student(33);
        Student student2 = new Student(2);
        Student student0 = new Student(0);
        Student student49 = new Student(49);
        Student student66 = new Student(66);
        Student student101 = new Student(101);
        List<Student> students = Arrays.asList(
            student2,
            student88,
            student71,
            student99,
            student70,
            student55,
            student50,
            student40,
            student51,
            student99,
            student33,
            student50,
            student0,
            student49,
            student66,
            student101
        );
        List<Student> result =
            school.collect(students, student -> student.getScore() >= 70 && student.getScore() <= 100);
        assertThat(result, hasItems(student88, student99, student71, student70, student99));
        assertThat(result,
            not(hasItems(student2, student55, student50, student40, student51, student33, student0, student49,
                student66, student101)));
    }

    /**
     * T.
     */
    @Test
    public void whenScoreFrom50To70Then10B() {
        School school = new School();
        Student student88 = new Student(88);
        Student student71 = new Student(71);
        Student student99 = new Student(99);
        Student student70 = new Student(70);
        Student student55 = new Student(55);
        Student student50 = new Student(50);
        Student student51 = new Student(51);
        Student student40 = new Student(40);
        Student student33 = new Student(33);
        Student student2 = new Student(2);
        Student student0 = new Student(0);
        Student student49 = new Student(49);
        Student student66 = new Student(66);
        Student student101 = new Student(101);
        List<Student> students = Arrays.asList(
            student2,
            student88,
            student71,
            student99,
            student70,
            student55,
            student50,
            student40,
            student51,
            student99,
            student33,
            student50,
            student0,
            student49,
            student66,
            student101
        );
        List<Student> result =
            school.collect(students, student -> student.getScore() >= 50 && student.getScore() <= 70);
        assertThat(result, hasItems(student55, student50, student66));
        assertThat(result,
            not(hasItems(student2, student88, student71, student99, student33, student0, student66, student101)));
    }

    /**
     * T.
     */
    @Test
    public void whenScoreFrom0To50Then10C() {
        School school = new School();
        Student student88 = new Student(88);
        Student student71 = new Student(71);
        Student student99 = new Student(99);
        Student student70 = new Student(70);
        Student student55 = new Student(55);
        Student student50 = new Student(50);
        Student student51 = new Student(51);
        Student student40 = new Student(40);
        Student student33 = new Student(33);
        Student student2 = new Student(2);
        Student student0 = new Student(0);
        Student student49 = new Student(49);
        Student student66 = new Student(66);
        Student student101 = new Student(101);
        List<Student> students = Arrays.asList(
            student2,
            student88,
            student71,
            student99,
            student70,
            student55,
            student50,
            student40,
            student51,
            student99,
            student33,
            student50,
            student0,
            student49,
            student66,
            student101
        );
        List<Student> result =
            school.collect(students, student -> student.getScore() >= 0 && student.getScore() <= 50);
        assertThat(result, hasItems(student2, student50, student40, student33, student0, student49));
        assertThat(result,
            not(hasItems(student88, student71, student99, student70, student55, student51, student66, student101)));
    }
}
