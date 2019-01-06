package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * ConsoleInput.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/29/2018
 */
public class ConsoleInput implements Input {

    /**
     * Считывание данных из консоли.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * ask.
     * Метод пишет в консоль вопрос для пользователя и получает ответ пользователя.
     *
     * @param question вопрос для пользователя.
     * @return ответ пользователя.
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * ask.
     * Метод вызывает метод ask(String question), форматирует ответ пользователя в число,
     * ищет есть ли полученное число в меню,
     * если -- есть, то возвращает ключ меню, равный полученному от пользователя числу,
     * если -- нет, то выбрасывается MenuOutException().
     *
     * @param question вопрос пользователю.
     * @param range    список ключей меню.
     * @return ключ меню или MenuOutException().
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
