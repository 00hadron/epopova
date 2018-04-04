package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {

    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }

    @Test
    public void whenOriginContainsSubThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.contains("ll");
        assertThat(result, is(true));
    }

    @Test
    public void whenOriginNoContainsSubThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.contains("xl");
        assertThat(result, is(false));
    }

    @Test
    public void whenOriginNoContainSubsAndMatchFirstElementThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.contains("lx");
        assertThat(result, is(false));
    }
}
