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
    public int calc(int n){
        int f = 1;
        for (int i = 2; i <= n ; i++) f *= i;
        return f;
    }
}
