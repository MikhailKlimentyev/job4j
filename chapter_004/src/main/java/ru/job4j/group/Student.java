package ru.job4j.group;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Set;

/**
 * The type Student.
 */
public class Student {

    private String name;
    private Set<String> units;

    /**
     * Instantiates a new Student.
     *
     * @param name  the name
     * @param units the units
     */
    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets units.
     *
     * @return the units
     */
    public Set<String> getUnits() {
        return units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;

        return new EqualsBuilder()
            .append(name, student.name)
            .append(units, student.units)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(name)
            .append(units)
            .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", units=").append(units);
        sb.append('}');
        return sb.toString();
    }
}
