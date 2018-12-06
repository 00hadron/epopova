package ru.job4j.list;
/**
 * Конвертация списка в двумерный массив.
 * @author epopova
 * @since 06.12.2018
 * @version $Id$
 */
import java.util.List;
import java.util.ListIterator;

public class ConvertList2Array {

    private int cells;

    public int[][] toArray(List<Integer> list, int rows) {
        if (list != null && rows != 0) {
            this.cells = list.size() / rows;
            if (list.size() % rows != 0) {
                this.cells++;
            }
            int[][] array = new int[rows][this.cells];
            ListIterator<Integer> here = list.listIterator();
            for (int r = 0; r != rows; r++) {
                for (int c = 0; c != this.cells; c++) {
                    if (!here.hasNext()) break;
                    array[r][c] = here.next();
                }
            } return array;
        } else {
            throw new NullPointerException("Входящий список пуст!");
        }
    }
}

