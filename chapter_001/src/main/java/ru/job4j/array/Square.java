package ru.job4j.array;

/*
 * Класс Square обрабатывает массивы.
 * @author epopova
 * @since 13.03.2018
 * @version 1
 */
public class Square {

    /**
     * Заполняет массив числами возведенными в квадрат.
     * @param bound размер массива.
     * @return результат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0; index != bound; index++) {
            rst[index] = (int)Math.pow(index, 2);
        }
        return rst;
    }
}
