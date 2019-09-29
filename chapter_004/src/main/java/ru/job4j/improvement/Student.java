package ru.job4j.improvement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The type Student.
 */
public class Student implements Comparable<Student> {

    private String name;
    private int scope;

    /**
     * Instantiates a new Student.
     *
     * @param name  the name
     * @param scope the scope
     */
    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
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
     * Sets name.
     *
     * @param name the name
     * @return {@link Student} student
     */
    public Student setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets scope.
     *
     * @return the scope
     */
    public int getScope() {
        return scope;
    }

    /**
     * Sets scope.
     *
     * @param scope the scope
     * @return {@link Student} student
     */
    public Student setScope(int scope) {
        this.scope = scope;
        return this;
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
            .append(scope, student.scope)
            .append(name, student.name)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(name)
            .append(scope)
            .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", scope=").append(scope);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.getScope(), o.getScope());
    }
}
