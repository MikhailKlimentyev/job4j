package ru.job4j.filter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The type Student.
 */
public class Student {

    private String name;
    private String surname;
    private int score;

    /**
     * Instantiates a new Student.
     */
    public Student() {
    }

    /**
     * Instantiates a new Student.
     *
     * @param score the score
     */
    public Student(int score) {
        this.score = score;
    }

    /**
     * Instantiates a new Student.
     *
     * @param name    the name
     * @param surname the surname
     * @param score   the score
     */
    public Student(String name, String surname, int score) {
        this.name = name;
        this.surname = surname;
        this.score = score;
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
     * @return {@Link Student} student
     */
    public Student setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     * @return {@Link Student} student
     */
    public Student setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     * @return {@Link Student} student
     */
    public Student setScore(int score) {
        this.score = score;
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
            .append(score, student.score)
            .append(name, student.name)
            .append(surname, student.surname)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(name)
            .append(surname)
            .append(score)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("name", name)
            .append("surname", surname)
            .append("score", score)
            .toString();
    }
}
