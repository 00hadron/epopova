package ru.job4j.sort;

import java.util.*;

/**
 * Сортировка пользователей.
 * (Структура treeset)
 * @version 0.2
 * @since 14.12.2018
 */
public class SortUser {
    /**
     * возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     * @param list
     * @return
     */
    public Set<User> sort (List<User> list) {
        Set<User> result = new TreeSet<User>(list);
        return result;
    }
}