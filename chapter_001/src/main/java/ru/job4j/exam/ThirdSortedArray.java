package ru.job4j.exam;

/**
 * ThirdSortedArray.
 *
 * @author Mikhail Klimentyev
 * @version $Id$
 * @since 12/22/2018
 */
public class ThirdSortedArray {

    /**
     * getArray.
     *
     * @param first  first array sorted in ascend order.
     * @param second second array sorted in ascend order.
     * @return third array consisting of first and second arrays and sorted in ascend order.
     */
    public int[] getArray(int[] first, int[] second) {
        int[] third = new int[first.length + second.length];

        int firstIndex = 0;
        int secondIndex = 0;
        int thirdIndex = 0;

        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] < second[secondIndex]) {
                third[thirdIndex] = first[firstIndex];
                firstIndex++;
            } else {
                third[thirdIndex] = second[secondIndex];
                secondIndex++;
            }
            thirdIndex++;
        }

        while (firstIndex < first.length) {
            third[thirdIndex] = first[firstIndex];
            firstIndex++;
            thirdIndex++;
        }

        while (secondIndex < second.length) {
            third[thirdIndex] = second[secondIndex];
            secondIndex++;
            thirdIndex++;
        }

        return third;
    }
}
