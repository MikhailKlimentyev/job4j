package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (int listItem : list) {
            array[i][j++] = listItem;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> resultList = new ArrayList<>();
        for (int[] array : list) {
            for (int element : array) {
                resultList.add(element);
            }
        }
        return resultList;
    }
}
