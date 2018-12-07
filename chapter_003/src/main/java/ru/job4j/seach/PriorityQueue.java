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
        ListIterator<Task> here = this.tasks.listIterator();
        while (here.hasNext() ) {
            if (here.next().getPriority() > task.getPriority()) {
                this.tasks.add(here.previousIndex(), task);
                break;
            }
            if (!here.hasNext()) {
                this.tasks.addLast(task);
                break;
            }
        }
        if (this.tasks.size() == 0) {
            this.tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}