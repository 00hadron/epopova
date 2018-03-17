package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"1", "1", "2", "2", "3", "3"};
        String[] expected = {"1", "2", "3"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(input);
        assertThat(result,arrayContainingInAnyOrder(expected));
    }
}
