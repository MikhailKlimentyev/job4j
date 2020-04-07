package ru.job4j.group;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The type Group test.
 */
public class GroupTest {
    /**
     * T.
     */
    @Test
    public void whenStudentsLinkedWithCommonSectionsThenStudentsGroupedBySections() {
        Group group = new Group();
        List<Student> students = Arrays.asList(
            new Student("Ivan", new HashSet<>(Arrays.asList("football", "music"))),
            new Student("Petr", new HashSet<>(Arrays.asList("volleyball", "tennis", "music"))),
            new Student("Fernando", new HashSet<>(Arrays.asList("drawing", "football")))
        );
        Map<String, Set<String>> actualMap = group.sections(students);
        Map<String, Set<String>> expectedMap = new HashMap<>() {{
            put("football", new HashSet<>(Arrays.asList("Ivan", "Fernando")));
            put("volleyball", new HashSet<>(Collections.singletonList("Petr")));
            put("drawing", new HashSet<>(Collections.singletonList("Fernando")));
            put("music", new HashSet<>(Arrays.asList("Ivan", "Petr")));
            put("tennis", new HashSet<>(Collections.singletonList("Petr")));
        }};
        assertThat(actualMap.size(), is(expectedMap.size()));
        assertThat(actualMap.entrySet(), everyItem(isIn(expectedMap.entrySet())));
    }

    /**
     * T.
     */
    @Test
    public void whenStudentsLinkedWithSeparateSectionsThenStudentsGroupedBySections() {
        Group group = new Group();
        List<Student> students = Arrays.asList(
            new Student("Ivan", new HashSet<>(Arrays.asList("football", "music"))),
            new Student("Petr", new HashSet<>(Collections.singletonList("tennis")))
        );
        Map<String, Set<String>> actualMap = group.sections(students);
        Map<String, Set<String>> expectedMap = new HashMap<>() {{
            put("football", new HashSet<>(Collections.singletonList("Ivan")));
            put("music", new HashSet<>(Collections.singletonList("Ivan")));
            put("tennis", new HashSet<>(Collections.singletonList("Petr")));
        }};
        assertThat(actualMap.size(), is(expectedMap.size()));
        assertThat(actualMap.entrySet(), everyItem(isIn(expectedMap.entrySet())));
    }
}
