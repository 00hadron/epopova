package ru.job4j.array;

/**
 * Сортировка массивов.
 * @author epopova
 * @since 15.03.2018
 * @version $Id$
 */
public class BubbleSort {

    /**
     * Cортирует массив. Пузыриковая сортировка.
     * @param array массив.
     * @return отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int arrayFragment = array.length - 1; arrayFragment > 0; arrayFragment--) {
            for (int index = 0; index < arrayFragment; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }
}
