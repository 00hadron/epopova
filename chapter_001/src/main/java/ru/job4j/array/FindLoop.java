package ru.job4j.array;

/*
 * Класс FindLoop обрабатывает массивы.
 * @author epopova
 * @since 14.03.2018
 * @version 1
 */
public class FindLoop {

    /**
     * Метод возвращает индекс искомого элемента.
     * @param data массив.
     * @param element элемент.
     * @return  result индекс элемента.
     */
    public int indexOf(int[] data, int element) {
        int result = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index]== element) {
                result = index;
                break;
            }
        }
        return result;
    }
}
