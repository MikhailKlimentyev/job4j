package ru.job4j.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
            List.of(1, 2, 3, 4, 5, 6, 7),
            3
        );
        int[][] expect = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2ArraysWith6ElementsThen1ListWith6Elements() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        ConvertList2Array convertList = new ConvertList2Array();
        List<Integer> result = convertList.convert(list);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}
