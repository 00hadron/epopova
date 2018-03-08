package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        converter.rubleToDollar(60, 60);
        int result = converter.getResult();
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        converter.rubleToEuro(70, 70);
        int result = converter.getResult();
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void when1DollarToRubleThen60() {
        Converter converter = new Converter();
        converter.dollarToRuble(1,60);
        int result = converter.getResult();
        assertThat(result, is(60));
    }

    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter();
        converter.euroToRuble(1, 70);
        int result = converter.getResult();
        assertThat(result, is(70));
    }
}