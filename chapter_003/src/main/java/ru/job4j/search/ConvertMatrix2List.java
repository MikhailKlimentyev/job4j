package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int[] array : matrix) {
            for (int element : array) {
                list.add(element);
            }
        }
        return list;
    }
}
