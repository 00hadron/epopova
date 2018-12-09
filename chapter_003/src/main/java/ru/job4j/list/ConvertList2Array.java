package ru.job4j.list;
/**
 * Конвертация списка в двумерный массив.
 * @author epopova
 * @since 06.12.2018
 * @version $Id$
 */
import java.util.List;
import static java.lang.Math.ceil;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) ceil((double) list.size() / rows);
        int[][] array = new int [rows][cells];
        int cell = 0;
        int row = 0;
        for (Integer lst : list) {
            array[row][cell++] = lst;
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }
}

