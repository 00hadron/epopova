package ru.job4j.start;

import ru.job4j.tracker.Tracker;

/**
 * Интрефейс UserAction - определение методов, общих для всех событий в StartUI.
 * @author epopova
 * @since 01.05.2018
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}