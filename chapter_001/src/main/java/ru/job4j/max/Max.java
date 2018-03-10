package ru.job4j.max;

/**
 * Класс Max сравнение чисел.
 * @author epopova
 * @since 10.03.2018
 * @version $Id$
 */
public class Max {

    /**
     * Overloading method max - Возвращает наибольшее число из двух.
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public int max(int first, int second) {
        return first < second ? second : first;
    }

    /**
     * Overloading method max - Возвращает наибольшее число из трех.
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return результат.
     */
    public int max(int first, int second, int third){
        return this.max(this.max(first, second),third);
    }
}
