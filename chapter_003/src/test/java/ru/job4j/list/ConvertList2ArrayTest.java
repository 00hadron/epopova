package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0 ,0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when8ElementsThen8() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 4);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}};
        assertThat(result, is(expect));
    }

    @Test
    public void when8ArraysThenList() {
        ConvertList2Array convertList = new ConvertList2Array();
        List<int[]> list  = new LinkedList<>();
        int[] data1 = {1 ,2, 3};
        int[] data2 = {4, 5, 6, 7, 8};
        int[] data3 = {9};
        list.add(data1);
        list.add(data2);
        list.add(data3);
        List<Integer> result = convertList.convert(list);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expect));
    }
}
