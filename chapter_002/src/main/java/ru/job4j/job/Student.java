package ru.job4j.job;

/**
 * Student.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/24/2018
 */
public class Student extends Profession {
    private int course;

    public Student(String name, String surname, String job, int course) {
        super(name, surname, job);
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public Knowledge study(Subject subject) {
        return new Knowledge();
    }
}
