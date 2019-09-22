package ru.job4j.stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ru.job4j.filter.Student;

/**
 * The type Student map test.
 */
public class StudentMapTest {
    /**
     * T.
     */
    @Test
    public void whenCollectListStudentsToMapThenSurnameStudentMap() {
        Student ivanov = new Student("Ivan", "Ivanov", 8);
        Student petrov = new Student("Ivan", "Petrov", 7);
        Student firstJordan = new Student("Michael", "Jordan", 6);
        Student jackson = new Student("Michael", "Jackson", 8);
        Student secondJordan = new Student("John", "Jordan", 5);
        Student romanov = new Student("Romanov", "Nikolay", 7);
        List<Student> students = Arrays.asList(
            ivanov,
            petrov,
            firstJordan,
            jackson,
            secondJordan,
            romanov
        );
        StudentMap studentMap = new StudentMap();
        Map<String, Student> surnameStudentMap = studentMap.collectStudentsToSurnameStudentMap(students);
        Map<String, Student> expectedSurnameStudentMap = new LinkedHashMap<String, Student>() {
            {
                put(ivanov.getSurname(), ivanov);
                put(petrov.getSurname(), petrov);
                put(firstJordan.getSurname(), firstJordan);
                put(jackson.getSurname(), jackson);
                put(romanov.getSurname(), romanov);
            }
        };
        assertThat(surnameStudentMap, is(expectedSurnameStudentMap));
    }
}
