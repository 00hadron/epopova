package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MergeSortTest {

    @Test
    public void whenArrayThenMergeSortArray() {
        int[] array = {5, 1, 2, 7, 3};
        int[] expected = {1, 2, 3, 5, 7};
        MergeSort mergeSort =  new MergeSort();
        int[] result = mergeSort.sort(array);
        assertThat(result, is(expected));
    }
}








