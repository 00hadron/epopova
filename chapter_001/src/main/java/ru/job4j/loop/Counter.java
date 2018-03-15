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
     * @return sym сумма четных элементов массива
     */
    public int add(int start, int finish) {
        int sym = 0;
        int[] array  = new int[finish - start + 1];
        for (int element = 0; element <= finish; element++) {
            int temp = start;
            array[element] = temp;
            if (array[element] % 2 == 0) {
                sym += temp;
            }
            start++;
        }
        return sym;
    }
}
