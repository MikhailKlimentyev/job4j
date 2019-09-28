package ru.job4j.search;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.List;

public class ConvertMatrix2ListTest {

    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
            {1, 2},
            {3, 4}
        };
        List<Integer> expect = List.of(1, 2, 3, 4);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on3ArrayThenList9() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when2on5ArrayThenList10() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10}
        };
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on2ArrayThenList6() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
