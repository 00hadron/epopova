package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SquareTest {

    @Test
    public void whenBound4thenArray0149() {
        int bound = 4;
        int[] expected = {0, 1, 4, 9};
        Square square  = new Square();
        int[] result = square.calculate(bound);
        assertThat(result, is(expected));
    }
}
