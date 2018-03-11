package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CounterTest {

    @Test
    public void whenArrayThenSumEvenNumbers() {
        int start  = 1;
        int finish = 10;
        Counter counter = new Counter();
        int result = counter.add(start, finish);
        int expected = 30;
        assertThat(result, is(expected));
    }
}
