package ru.job4j.tracker;

/**
 * BaseAction.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/20/2019
 */
public abstract class BaseAction implements UserAction {

    /**
     * Номер пункта меню.
     */
    private final int key;

    /**
     * Название пункта меню.
     */
    private final String name;

    /**
     * BaseAction.
     * конструктор.
     *
     * @param key  номер пункта меню.
     * @param name название пункта меню.
     */
    protected BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * key.
     * возвращает номер пункта меню.
     *
     * @return номер пункта меню.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * info.
     * возвращает номер пункта меню и название пункта меню.
     *
     * @return Номер пункта меню и название пункта меню.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
