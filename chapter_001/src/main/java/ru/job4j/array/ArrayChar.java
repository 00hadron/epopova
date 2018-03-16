package ru.job4j.array;
/**
 * Сравнение символьных массивов.
 * @author epopova
 * @since 16.03.2018
 * @version $Id$
 */

import java.util.Arrays;

public class ArrayChar {
    private char[] data;

    /**
     * Конструктор.
     * @param line
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] arrayPrefix = prefix.toCharArray();
        char[] arrayShortCopy = Arrays.copyOf(this.data, arrayPrefix.length);
        if (!Arrays.equals(arrayPrefix,arrayShortCopy)) {
            result = false;
        }
        return result;
    }
}
