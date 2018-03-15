package ru.job4j.array;
/**
 * Работа с матрицей.
 * @author epopova
 * @since 16.03.2018
 * @version $Id$
 */

public class Matrix {

    /**
     * Заполнить матрицу таблицы умножения.
     * @param size размер массива.
     * @return массив.
     */
   public int[][] multiple(int size) {
       int[][] data = new int[size][size];
       for (int row = 0; row < size; row++) {
           for (int column = 0; column < size; column++) {
               data[row][column] = (row + 1)*(column + 1);
           }
       }
       return data;
   }
}
