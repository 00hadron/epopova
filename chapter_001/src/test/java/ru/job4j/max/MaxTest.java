package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс MaxTest.
 * @author epopova
 * @since 08.03.2018
 * @version $Id$
 */
public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        int first = 1;
        int second = 2;
        int expected = 2;
        int result;
        Max maxim = new Max();
        result = maxim.max(first, second);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSecondLessFirst() {
        int first = 4;
        int second = 3;
        int expected = 4;
        int result;
        Max maxim = new Max();
        result =  maxim.max(first, second);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSecondNoLessFirst() {
        int first = 4;
        int second = 4;
        int expected = 4;
        int result;
        Max maxim = new Max();
        result =  maxim.max(first, second);
        assertThat(result, is(expected));
    }
}
