package ru.job4j.tracker;

import java.util.List;

/**
 * Input.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/30/2018
 */
public interface Input {

    public abstract String ask(String question);

    public abstract int ask(String question, int[] range);
}
