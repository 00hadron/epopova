package ru.job4j.list;

/**
 * Конвертация двумерного массивa в список.
 * @author epopova
 * @since 09.12.2018
 * @version $Id$
 */
import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] rows : array) {
            for (int element : rows) {
                list.add(element);
            }
        }
        return list;
    }
}
