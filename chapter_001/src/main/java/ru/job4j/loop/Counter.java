package ru.job4j.loop;

/**
 * Класс Counter обрабатывает диапазон чисел.
 * @author epopova
 * @since 11.03.2018
 * @version $Id$
 */
public class Counter {

    /**
     *  Метод должен вычислять
     *  сумму четныx чисел в диапазоне от start до finish
     * @param start начало диапазона
     * @param finish конец диапазона
     * @return sym сумма четных элементов
     */
    public int add(int start, int finish) {
        int sym = 0;
        for (int index = start; index <= finish; index++) {
            if (index % 2 == 0) {
                sym += index;
            }
        }
        return sym;
    }
}
