package ru.job4j.array;

/**
 * FindLoop.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/01/2018
 */
public class FindLoop {

    /**
     * indexOf.
     * <p>
     * Method receives array and element
     * <p>
     * and returns either index of the element in the array
     * <p>
     * or -1 if the element is not found in the array
     *
     * @param data array.
     * @param el   element.
     * @return either index of element in array or -1
     */
    public int indexOf(int[] data, int el) {
        int result = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                result = index;
                break;
            }
        }
        return result;
    }
}
