package ru.job4j.list;
/**
 * Конвертация списка в двумерный массив.
 * @author epopova
 * @since 06.12.2018
 * @version $Id$
 */
import java.util.List;

public class ConvertList2Array {

    private int cells;

    public int[][] toArray(List<Integer> list, int rows) {
        if (list != null && rows != 0) {
            this.cells = list.size() / rows;
            if (list.size() % rows != 0) {
                this.cells++;
            }
            int[][] array = new int [rows][this.cells];
            int cell = 0;
            int lst = 0;
            int row = 0;
            while (row != rows) {
                for (int[] a : array) {
                    if (lst == list.size()) {
                        break;
                    }
                    array[row][cell] = list.get(lst);
                    cell++;
                    lst++;
                    if (cell == this.cells) {
                        break;
                    }
                }
                row++;
                cell = 0;
            }
            return array;
        } else {
            throw new NullPointerException("Входящий список пуст!");
        }
    }
}

