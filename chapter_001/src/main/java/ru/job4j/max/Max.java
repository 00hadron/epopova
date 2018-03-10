package ru.job4j.max;

/**
 * Класс Max сравнение чисел.
 * @author epopova
 * @since 08.03.2018
 * @version $Id$
 */
public class Max {
    private int result;

    /**
     * Overloading method max - Возвращает наибольшее число из двух.
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public int max(int first, int second) {
        this.result = first < second ? second : first ;
        return this.result;
    }

    /**
     * Overloading method max - Возвращает наибольшее число из трех.
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return результат.
     */

    public int max(int first, int second, int third){
        int temp = this.max(first, second);
        this.result = this.max(temp, third);
        return this.result;
    }
}
