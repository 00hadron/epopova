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
        int totalElement = 0;
        int sym = 0;
        for (int temp = start; temp <= finish; temp++) {
            totalElement++;
        }
        int[] array  = new int[totalElement];
        for (int element : array) {
            array[element] = start++;
            if (array[element] % 2 == 0) {
                sym = sym + array[element];
            }
        }
        return sym;
    }
}
