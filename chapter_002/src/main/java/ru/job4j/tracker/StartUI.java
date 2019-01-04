package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * StartUI.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/29/2018
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод запускает основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            int key = Integer.valueOf(this.input.ask("Please, select: "));
            menu.select(range.get(key));
            if (key == 6) {
                break;
            }
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Метод запускает программу.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
