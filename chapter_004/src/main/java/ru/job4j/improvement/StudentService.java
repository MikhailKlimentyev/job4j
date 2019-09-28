package ru.job4j.improvement;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Student service.
 */
public class StudentService {
    /**
     * Level of list.
     *
     * @param students the students
     * @param bound    the bound
     * @return the list
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
            .sorted(Comparator.reverseOrder())
            .takeWhile(student -> student.getScope() > bound)
            .collect(Collectors.toList());
    }
}
