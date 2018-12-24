package ru.job4j.job;

/**
 * Profession.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/24/2018
 */
public class Profession {
    private String name;
    private String surname;
    private String job;

    public Profession(String name, String surname, String job) {
        this.name = name;
        this.surname = surname;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getJob() {
        return job;
    }
}
