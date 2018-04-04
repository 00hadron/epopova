package ru.job4j.array;
/**
 * Сравнение символьных массивов.
 * @author epopova
 * @since 04.04.2018
 * @version $Id$
 */

import java.util.Arrays;

public class ArrayChar {
    private char[] data;

    /**
     * Конструктор.
     *
     * @param line
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return flag.
     */
    public boolean startWith(String prefix) {
        boolean flag = true;
        char[] arrayPrefix = prefix.toCharArray();
        char[] arrayShortCopy = Arrays.copyOf(this.data, arrayPrefix.length);
        for (int index = 0; index < arrayPrefix.length; index++)
            if (arrayPrefix[index] != arrayShortCopy[index]) {
                flag = false;
                break;
            }
        return flag;
    }

    /**
     * contains проверяет, входит ли подстрока в строку.
     * @param sub подстрока.
     * неявный параметр data строка, форматированная в массив.
     * @return flag.
     */
    public boolean contains(String sub) {
        boolean flag = true;
        char[] arraySub = sub.toCharArray();
        branchDo:
        do {
            for (int indexOrigin = 0; indexOrigin <= this.data.length - arraySub.length; indexOrigin++) {
                char[] arrayOriginShort = Arrays.copyOfRange(this.data, indexOrigin, (indexOrigin + arraySub.length));
                int count = 0;
                for (int index = 0; index < arraySub.length; index++) {
                    if (arrayOriginShort[index] != arraySub[index]) {
                        flag = false;
                        break;
                    } else {
                        count++;
                    }
                }
                if (count == arraySub.length) {
                    flag = true;
                    break branchDo;
                }
            }
        } while (flag);
        return flag;
    }
}