package ru.job4j.seach;

/**
 * Вставка по приоритету в связанный список.
 * @author epopova
 * @since 05.12.2018
 * @version $Id$
 */
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Вставка по приоритету в связанный список.
 * @author epopova
 * @since 05.12.2018
 * @version $Id$
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int count = 0;
        for (Task t : this.tasks) {
            if (t.getPriority() > task.getPriority()) {
                break;
            }
            count++;
        }
        this.tasks.add(count, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}