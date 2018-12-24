package ru.job4j.job;

/**
 * Engineer.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/24/2018
 */
public class Engineer extends Profession {
    public Engineer(String name, String surname, String job) {
        super(name, surname, job);
    }

    public House build(Scheme scheme) {
        return new House();
    }
}
