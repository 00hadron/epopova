package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    private static final int EURO_RATE = 70;
    private static final int DOLLAR_RATE = 60;

    @Test
    public void when60RubleToDollarThen1() {
        int valueRubleToDollar = 60;
        int expected = 1;
        int result;
        Converter converter = new Converter();
        converter.rubleToDollar(valueRubleToDollar, DOLLAR_RATE);
        result = converter.getResult();
        assertThat(result, is(expected));
    }

    @Test
    public void when70RubleToEuroThen1() {
        int valueRubleToEuro = 70;
        int expected = 1;
        int result;
        Converter converter = new Converter();
        converter.rubleToEuro(valueRubleToEuro, EURO_RATE);
        result = converter.getResult();
        assertThat(result, is(expected));
    }

    @Test
    public void when1DollarToRubleThen60() {
        int valueDollarToRuble = 1;
        int expected = 60;
        int result;
        Converter converter = new Converter();
        converter.dollarToRuble(valueDollarToRuble, DOLLAR_RATE);
        result = converter.getResult();
        assertThat(result, is(expected));
    }

    @Test
    public void when1EuroToRubleThen70() {
        int valueEuroToRuble = 1;
        int expected = 70;
        int result;
        Converter converter = new Converter();
        converter.euroToRuble(valueEuroToRuble, EURO_RATE);
        result = converter.getResult();
        assertThat(result, is(expected));
    }
}