package ru.job4j.array;

/**
 * ArrayChar.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/01/2018
 */
public class ArrayChar {

    /*
     * Contains char[] array.
     */
    private char[] data;

    /**
     * Constructor.
     *
     * @param line String array
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * startWith.
     * Проверяет, что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return true если слово начинается с префикса.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index != 2; index++) {
            if (this.data[index] != value[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
