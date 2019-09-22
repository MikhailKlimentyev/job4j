package ru.job4j.stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * The type Matrix to list test.
 */
public class MatrixToListTest {
    /**
     * T.
     */
    @Test
    public void whenConvertMatrixToListThenList() {
        Integer[][] matrix = new Integer[][]{{0, 1}, {2, 3}, {4, 5}};
        MatrixToList matrixToList = new MatrixToList();
        List<Integer> resultList = matrixToList.convertMatrixToList(matrix);
        List<Integer> expectedList = Arrays.asList(0, 1, 2, 3, 4, 5);
        assertThat(resultList, is(expectedList));
    }
}
