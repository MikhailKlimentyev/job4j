package ru.job4j.job;

/**
 * Doctor.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/24/2018
 */
public class Doctor extends Profession {
    public Doctor(String name, String surname, String job) {
        super(name, surname, job);
    }

    public Recipe treat(Patient patient) {
        return new Recipe();
    }
}
