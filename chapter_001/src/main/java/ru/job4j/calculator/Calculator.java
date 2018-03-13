package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author epopova
 * @since 16.02.2018
 * @version $Id$
 */
public class Calculator {
    private double result;

    /**
     * Method add  - сложение двух чисел.
     * @param first - первое число
     * @param second - второе число
     * неявный параметр result - сумма чисел
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract  - вычитание двух чисел.
     * @param first - первое число
     * @param second - второе число
     * неявный параметр result - разность чисел
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div  - деление двух чисел.
     * @param first - первое число
     * @param second - второе число
     * неявный параметр result - отношение чисел
     */
    public void div(double first, double second) {
        this.result = second / first;
    }

    /**
     * Method multiple  - произведение двух чисел.
     * @param first - первое число
     * @param second - второе число
     * неявный параметр result - произведение чисел
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     * неявный параметр result
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}
