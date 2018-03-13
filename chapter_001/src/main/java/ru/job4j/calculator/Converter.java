package ru.job4j.calculator;

/**
 * Корвертер валюты.
 */
public class Converter {
    private int result;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли, euroRate курс евро.
     */
    public void rubleToEuro(int value, int euroRate) {
        this.result = value / euroRate;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли, dollarRate курс доллара.
     */
    public void rubleToDollar(int value, int dollarRate) {
        this.result = value / dollarRate;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value Евро, euroRate курс евро.
     */
    public void euroToRuble(int value, int euroRate) {
        this.result = value * euroRate;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value Доллары, dollarRate курс доллара.
     */
    public void dollarToRuble(int value, int dollarRate) {
        this.result = value * dollarRate;
    }

    /**
     * Method getResult.
     * @return result
     */
    public int getResult() {
        return this.result;
    }
}
