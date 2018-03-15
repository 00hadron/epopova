package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void whenArrayThenBubbleSortArray() {
        int[] array = {5, 1, 2, 7, 3};
        int[] expected = {1, 2, 3, 5, 7};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(array);
        assertThat(result, is(expected));
    }
}
