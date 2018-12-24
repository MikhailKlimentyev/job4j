package ru.job4j.job;

/**
 * Teacher.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/24/2018
 */
public class Teacher extends Profession {
    public Teacher(String name, String surname, String job) {
        super(name, surname, job);
    }

    public Engineer teach(Student student) {
        String name = "";
        String surname = "";
        String job = "";
        return new Engineer(name, surname, job);
    }
}
