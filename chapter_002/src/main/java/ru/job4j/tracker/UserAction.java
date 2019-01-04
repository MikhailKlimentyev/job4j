package ru.job4j.tracker;

/**
 * UserAction.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/04/2019
 */
public interface UserAction {
    /**
     * key.
     * Метод возвращает номер пункта меню.
     *
     * @return ключ.
     */
    public int key();

    /**
     * execute.
     * Метод выполняет действие, соответствующее пункту меню.
     * Например Add Item, Show Items, Update Item, Delete Item, Find Item By Id,
     * Find Items By Name, Exit Program.
     *
     * @param input   объект типа Input.
     * @param tracker объект типа Tracker
     */
    public void execute(Input input, Tracker tracker);

    /**
     * info.
     * Метод возвращает информацию о соответствующем пункте меню.
     *
     * @return Строка меню.
     */
    public String info();
}
