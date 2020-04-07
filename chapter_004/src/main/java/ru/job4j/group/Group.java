package ru.job4j.group;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * The type Group.
 */
public class Group {
    /**
     * Groups students by units.
     * As a result returns map
     * where key is unit
     * and value is set of names of students linked with this unit.
     *
     * @param students the students
     * @return the map
     */
    public Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
            .flatMap(student -> student.getUnits().stream()
                .map(unit -> new Holder(unit, student.getName()))
            )
            .collect(Collectors.groupingBy(
                holder -> holder.unit, //classifier
                Collector.of( //custom collector
                    HashSet::new, //supplier()
                    (set, e) -> set.add(e.student), //accumulator()
                    (left, right) -> { //combiner()
                        left.addAll(right);
                        return left;
                    })
                )
            );
    }

    /**
     * The type Holder.
     */
    static class Holder {
        /**
         * The Unit.
         */
        String unit;
        /**
         * The Student.
         */
        String student;

        /**
         * Instantiates a new Holder.
         *
         * @param unit    the unit
         * @param student the student
         */
        Holder(String unit, String student) {
            this.unit = unit;
            this.student = student;
        }
    }
}
