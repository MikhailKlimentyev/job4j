package ru.job4j.filter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The type School.
 */
public class School {
    /**
     * Collect list.
     *
     * @param students  the students
     * @param predicate the predicate
     * @return the list
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }
}
