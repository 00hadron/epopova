package ru.job4j.loop;

/**
 * Класс работает с факториалами.
 * @author epopova
 * @since 11.03.2018
 * @version $Id$
 */
public class Factorial {

    /**
     * Считает факториал числа.
     * @param n число.
     * @return f факториал числа.
     */
    public int calc(int n) {
        int value = 1;
        for (int count = 2; count <= n; count++) {
            value *= count;
        }
        return value;
    }
}
