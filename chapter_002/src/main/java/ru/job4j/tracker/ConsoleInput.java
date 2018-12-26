package ru.job4j.tracker;

import java.util.Scanner;

/**
 * ConsoleInput.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/29/2018
 */
public class ConsoleInput {

    /**
     * ask.
     * Метод пишет в консоль вопрос для пользователя и получает ответ пользователя.
     *
     * @param question вопрос для пользователя.
     * @return ответ пользователя.
     */
    public String ask(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine();
    }
}
