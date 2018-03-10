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

        System.out.println("test whenFirstLessSecond  ");
        System.out.println(first + ", " + second);
        System.out.println("максимальное число = " + result);
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

        System.out.println("test whenSecondLessFirs ");
        System.out.println(first + ", " + second);
        System.out.println("максимальное число = " + result);
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

        System.out.println("test whenSecondNoLessFirst");
        System.out.println(first + ", " + second);
        System.out.println("максимальное число = " + result);
    }

    @Test
    public void whenFirstLessSecondAndThird() {
        int first = 1;
        int second = 2;
        int third = 3;
        int expected = 3;
        int result;
        Max maxim = new Max();
        result = maxim.max(first, second, third);
        assertThat(result, is(expected));

        System.out.println("test whenFirstLessSecondAndThird ");
        System.out.println(first + ", " + second + ", " + third );
        System.out.println("максимальное число = " + result);
    }

    @Test
    public void whenSecondLessFirstAndThird() {
        int first = 4;
        int second = 3;
        int third = 5;
        int expected = 5;
        int result;
        Max maxim = new Max();
        result =  maxim.max(first, second, third);
        assertThat(result, is(expected));

        System.out.println("test whenSecondLessFirstAndThird");
        System.out.println(first + ", " + second + ", " + third );
        System.out.println("максимальное число = " + result);
    }

    @Test
    public void whenSecondNoLessFirstAndThird() {
        int first = 4;
        int second = 4;
        int third = 4;
        int expected = 4;
        int result;
        Max maxim = new Max();
        result =  maxim.max(first, second, third);
        assertThat(result, is(expected));

        System.out.println("test whenSecondNoLessFirstAndThird");
        System.out.println(first + ", " + second + ", " + third );
        System.out.println("максимальное число = " + result);
    }
}
