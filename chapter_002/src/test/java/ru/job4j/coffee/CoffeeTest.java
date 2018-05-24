package ru.job4j.coffee;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class CoffeeTest {
    private int price = 35;

    @Test
    public void whenValue100andPrice35thenChange() {
        int value = 100;
        int[] expected = {50, 10, 5};
        Coffee coffee = new Coffee();
        coffee.setPrice(this.price);
        coffee.setValue(value);
        int[] result = coffee.changes();
        assertThat(result, is(expected));
    }

    @Test
    public void whenValue500andPrice35thenChange() {
        int value = 500;
        int[] expected = {200, 200, 50, 10, 5};
        Coffee coffee = new Coffee();
        coffee.setPrice(this.price);
        coffee.setValue(value);
        int[] result = coffee.changes();
        assertThat(result, is(expected));
    }

    @Test
    public void whenValue10andPrice35thenException() throws UnsupportedOperationException {
        int value = 10;
        Coffee coffee = new Coffee();
        coffee.setPrice(this.price);
        coffee.setValue(value);
        try {
            coffee.changes();
        } catch (UnsupportedOperationException thrown) {
            Assert.assertEquals("Недостаточно введенных денег!", thrown.getMessage());
        }
    }

    @Test
    public void whenValue1000andPrice35thenException() throws UnsupportedOperationException {
        int value = 1000;
        Coffee coffee = new Coffee();
        coffee.setPrice(this.price);
        coffee.setValue(value);
        try {
            coffee.changes();
        } catch (UnsupportedOperationException thrown) {
            Assert.assertEquals("Такие купюры не существуют!", thrown.getMessage());
        }
    }
}

