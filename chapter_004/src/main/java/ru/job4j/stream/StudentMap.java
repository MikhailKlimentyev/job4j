package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ru.job4j.filter.Student;

/**
 * The type Student map.
 */
public class StudentMap {
    /**
     * Collect students to surname student map map.
     *
     * @param students the students
     * @return the map
     */
    public Map<String, Student> collectStudentsToSurnameStudentMap(List<Student> students) {
        return students.stream().collect(
            Collectors.toMap(
                student -> student.getSurname(),
                student -> student,
                (key, dupeKey) -> key
            ));
    }
}