package ru.job4j.tracker;

import java.util.*;

/**
 * Класс хранит и обрабатывает заявки.
 * @version 0.1
 * @since 06.04.18
 */
public class Tracker {
    private static final int SIZE = 100;
    private final Item[] items = new Item[SIZE];
    private int position = 0;
    private static final Random RN = new Random();
    private static final int SHIFT = 1;

    /**
     * Добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Редактирование заявок.
     * @param id заменяемого элемента массива.
     * @param item - эти данные перезаписать в заменяемый элемент массива.
     * */
    public void replace(String id, Item item) {
        Item find = findById(id);
        item.setId(find.getId());
        delete(find.getId());
    }

    /**
     * удаляет заявку.
     * @param id
     */
    public void delete(String id) {
        int removeInx = SIZE;
        for (int index = 0; index != items.length; index++) {
            if (findById(id).equals(items[index])) {
                removeInx = index;
                break;
            }
        }
        System.arraycopy(this.items, removeInx + SHIFT, this.items, removeInx ,this.items.length - removeInx - SHIFT);
    }

    /**
     * Получает список всех заявок.
     * @return
     */
    public Item[] findAll() {
        int cut = 1;
        for (int index = 0; index != this.items.length; index++) {
            if ( items[index] == null) {
                cut = index;
                break;
            }
        }
        return Arrays.copyOf(items, cut);
    }

    /**
     * Получает список по имени.
     * @param name
     * @return
     */
    public Item[] findByName(String name) {
        int count = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name) ) {
                count++;
            }
        }
        Item[] result = new Item[count];
        int index = 0;
        for (Item element : items) {
            if (element != null && element.getName().equals(name)) {
                result[index] = element;
                index++;
            }
        }
        return result;
    }

    /**
     * Ищет элемент по уникальному ключу для заявки.
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item result = null;
        for (Item element : items) {
            if (element != null && element.getId().equals(id)) {
                result = element;
                break;
            }
        }
        return result;
    }
    /**
     * Генерирует уникальный ключ для заявки.
     * @return key.
     */
    String generateId() {
        return String.valueOf(RN.nextInt() + System.currentTimeMillis());
    }
}
