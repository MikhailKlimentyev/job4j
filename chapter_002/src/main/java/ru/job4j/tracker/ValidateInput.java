package ru.job4j.tracker;

import java.util.List;

/**
 * ValidateInput.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 01/06/2019
 */
public class ValidateInput implements Input {

    /**
     * Ввод данных из консоли.
     */
    private final Input input;

    /**
     * Конструктор.
     *
     * @param input объект класса Input.
     */
    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * ask.
     *
     * @param question вопрос пользователю, который выведется в консоль.
     * @return ответ пользователя, полученный через консоль.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * ask.
     * Метод вызывает метод ask(String question, List<Integer> range),
     * при корректном вводе(число из списка меню) возвращается ключ меню,
     * при некорректном вводе, обрабатываются NumberFormatException и MenuOutException
     * и у пользователя запрашивается ключ меню, пока не будет получен валидный.
     *
     * @param question вопрос пользователю.
     * @param range    список ключей меню.
     * @return ключ меню.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter number.");
            } catch (MenuOutException moe) {
                System.out.println("Please, enter number from menu.");
            }
        } while (invalid);
        return value;
    }
}
