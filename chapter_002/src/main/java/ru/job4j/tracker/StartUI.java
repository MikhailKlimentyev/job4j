package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
     * Вывод данных.
     */
    private final Consumer<String> output;

    /**
     * Флаг для выхода из цикла программы.
     */
    private boolean working = true;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     * @param output  вывод данных.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод запускает основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActions().size(); i++) {
            range.add(i);
        }
        do {
            output.accept("Menu:");
            menu.show();
            int key = this.input.ask("Please, select menu number: ", range);
            menu.select(range.get(key));
        } while (this.working);
    }

    /**
     * stop.
     * Метод меняет состояние переменной, которая управляет основным циклом программы, на false.
     */
    public void stop() {
        this.working = false;
    }

    /**
     * Метод запускает программу.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
