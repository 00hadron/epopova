package ru.job4j.start;

/**
 * Интерфейс Input для реализации полиморфизма для способов ввода ответов пользователя.
 *@author epopova
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
