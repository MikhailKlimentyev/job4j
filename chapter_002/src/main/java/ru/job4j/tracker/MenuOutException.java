package ru.job4j.tracker;

/**
 * MenuOutException.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/06/2019
 */
public class MenuOutException extends RuntimeException {

    /**
     * Конструктор.
     *
     * @param message сообщение об ошибке.
     */
    public MenuOutException(String message) {
        super(message);
    }
}
