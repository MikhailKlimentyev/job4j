package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Matrix to list.
 */
public class MatrixToList {
    /**
     * Convert matrix to list list.
     *
     * @param matrix the matrix
     * @return the list
     */
    public List<Integer> convertMatrixToList(Integer[][] matrix) {
        return Stream.of(matrix)
            .flatMap(x -> Arrays.stream(x))
            .collect(Collectors.toList());
    }
}
