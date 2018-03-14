package ru.job4j.array;

import org.junit.Test;
import org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayElement6ThenIndex3() {
        int[] data = {5, 4, 3, 6, 7};
        int element = 6;
        int expected = 3;
        FindLoop findLoop = new FindLoop();
        int result = findLoop.indexOf(data, element);
        assertThat(result, is(expected));
    }

    @Test
    public void whenArrayElement10ThenNoIndex() {
        int[] data = {5, 4, 3, 6, 7};
        int element = 10;
        int expected = -1;
        FindLoop findLoop = new FindLoop();
        int result = findLoop.indexOf(data, element);
        assertThat(result, is(expected));
    }
}
