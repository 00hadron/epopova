package ru.job4j.array;

/*
 * Класс обрабатывает массивы.
 * @author epopova
 * @since 14.03.2018
 * @version 1
 */
public class Turn {

    /**
     * Метод переворачивает массив.
     * @param array массив.
     * @return перевернутый массив.
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return  array;
    }
}
