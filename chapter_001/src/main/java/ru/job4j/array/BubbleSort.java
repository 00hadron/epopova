package ru.job4j.array;

import java.util.Arrays;

/**
 * Сортировка массивов.
 * @author epopova
 * @since 04.04.2018
 * @version $Id$
 */
public class BubbleSort {

    /**
     * Cортирует массив. Пузыриковая сортировка.
     * @param array массив.
     * @return отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int arrayFragment = array.length - 1; arrayFragment > 0; arrayFragment--) {
            for (int index = 0; index < arrayFragment; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * Копирует два массива в общий массив и вызывает метод сортировки.
     * @param arrayOne первый массив.
     * @param arrayTwo второй массив.
     * @return отсортированный общий массив.
     */
    public int[] bubbleSortTwoArray(int[] arrayOne, int[] arrayTwo) {
        int[] arrayBoth = new int[arrayOne.length + arrayTwo.length];
        for (int indexBoth = 0; indexBoth < arrayOne.length; indexBoth++ ) {
            arrayBoth[indexBoth] = arrayOne[indexBoth];
        }
        int indexTwo = 0;
        for (int indexBoth = arrayOne.length; indexBoth < arrayBoth.length; indexBoth++) {
            arrayBoth[indexBoth] = arrayTwo[indexTwo];
            indexTwo++;
        }
        BubbleSort bubbleSort = new BubbleSort();
        return bubbleSort.sort(arrayBoth);
    }

    /**
     * Копирует два массива в общий массив, сортирует по собственным методам Java.
     * @param arrayOne первый массив.
     * @param arrayTwo второй массив.
     * @return отсортированный общий массив.
     */
    public int[] bubbleSortTwoArrayWithJavaMethod(int[] arrayOne, int[] arrayTwo) {
        int[] arrayBoth = new int[arrayOne.length + arrayTwo.length];
        System.arraycopy(arrayOne, 0,arrayBoth, 0, arrayOne.length);
        System.arraycopy(arrayTwo, 0, arrayBoth, arrayOne.length, arrayTwo.length);
        Arrays.sort(arrayBoth);
        return arrayBoth;
    }
}

