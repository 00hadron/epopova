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
     * Возвращает наибольшее число из двух.
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public int max(int first, int second) {
        this.result = first < second ? second : first ;
        System.out.println("Максимальное из двух чисел "+ first+ " & " + second + " ---> " + this.result);
        return this.result;
    }


}
