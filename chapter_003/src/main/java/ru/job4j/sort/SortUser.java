package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * Сортировка пользователей.
 * (Структура treeset)
 * @version 0.1
 * @since 14.12.2018
 */
public class SortUser {
    /**
     * возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     * @param list
     * @return
     */
    public Set<User> sort (List<User> list) {
        Set<User> result;
        result = new TreeSet<User>();
        result.addAll(list);
        return result;
    }
}