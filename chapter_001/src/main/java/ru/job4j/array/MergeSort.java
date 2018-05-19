package ru.job4j.array;

import java.util.Arrays;

/**
 * Сортировка слиянием.
 * @author epopova
 * @since 18.05.2018
 */

public class MergeSort {

    int[] first;
    int[] second;
    int[] buffer;
    int[] source;
    int[] merged;
    int piece = 1;

    public void setSizeFirst() {
        this.first = new int[this.piece];
    }
    public void setSizeSecond() {
        this.second = new int[this.piece];
    }
    public void setSizeBuffer() {
        this.buffer = new int[this.source.length];
    }
    public void setSizeMerged() {
        this.merged = new int[this.first.length + this.second.length];
    }

    /**
     * Метод для функции merge (слияние двух массивов).
     * Берутся крайние элементы в массивах first, second. Наименьший из них записывается в массив merged.
     * Короткий хвост массива, который уже не с чем сортировать, перезаписываюся в merged как есть.
     */
    public void merge() {
        int left = 0;
        int right = 0;
        int dest = 0;
        setSizeMerged();

        while (left <= this.first.length && right <= this.second.length) {
            if (this.first[left] <= this.second[right]) {
                this.merged[dest] = this.first[left];
                left++;
            }
            if (this.first[left] > this.second[right]) {
                this.merged[dest] = this.second[right];
                right++;
            }
            dest++;
        }
        while (left < this.first.length) {
            this.merged[dest] = this.first[left];
            dest++;
            left++;
        }
        while (right < this.second.length) {
            this.merged[dest] = this.second[right];
            dest++;
            right++;
        }
    }

    /**
     * Классическая восходящая схема двухстороннего алгоритма слиянием (down top implementation).
     * Разбить на одноэлементные подмассивы. Сливать в пары.
     * В цикле while массив src разбит на пары подмассивов длины piece.
     * каждый массив упорядочен методом merge.
     * int pointer - индекс начала пары подмассивов.
     * int lastPiece - длина второго подмассива (в конце массива piece может быть короче).
     * Короткий хвост массива, который уже не с чем сортировать, перезаписываюся как есть.
     * piece увеличить в 2 раза. Поменять местами src и buffer.
     * проверить в каком из массивов лежит отсортированный массив.
     * O(n log n)
     */
    public int[] sort(int[] source) {
        this.source = source;
        this.setSizeBuffer();
        if (this.source.length < 1) {
            this.buffer = this.source;
        }
        if (this.source.length == 2) {
            if (this.source[0] > this.source[1]) {
                int temp = source[0];
                this.source[0] = this.source[1];
                this.source[1] = temp;
            }
            this.buffer = this.source;
        }

        while (this.piece < this.source.length) {
            int pointer = 0;
            while (pointer < this.source.length - this.piece) {
                int lastPiece = this.piece;
                if (pointer + this.piece + lastPiece > source.length) {
                    lastPiece = source.length - (pointer + this.piece);
                }
                this.setSizeFirst();
                this.setSizeSecond();
                this.setSizeMerged();
                this.merge();
                System.arraycopy(this.merged, 0, this.buffer, pointer, this.merged.length);
                pointer = pointer + this.piece + lastPiece;
            }
            while (pointer < this.source.length) {
                System.arraycopy(this.source, this.source.length - pointer, this.buffer, this.buffer.length - pointer, this.buffer.length - pointer);
                this.piece *= 2;
                int[] temp = this.source;
                this.source = this.buffer;
                this.buffer = temp;
            }
        }
        //  if (this.source != )

        return this.buffer;
    }
}
