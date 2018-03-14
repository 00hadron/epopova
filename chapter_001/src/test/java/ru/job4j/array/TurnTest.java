package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TurnTest {

    @Test
    public void whenArrayEven(){
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] expected = {6, 5, 4, 3, 2, 1};
        Turn turn = new Turn();
        int[] result = turn.back(array);
        assertThat(result, is(expected));
    }

    @Test
    public void whenArrayOdd(){
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        Turn turn = new Turn();
        int[] result = turn.back(array);
        assertThat(result, is(expected));

    }
}
