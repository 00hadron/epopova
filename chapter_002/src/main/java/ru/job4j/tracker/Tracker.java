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
        for (int index = 0; index != SIZE; index++)
            if (items[this.position] != null && items[this.position].equals(find)) {
                items[this.position] = item;
                break;
            }
    }

    /**
     * удаляет заявку.
     * @param id
     */
    public void delete(String id) {
         final int SHIFT = 1;
        Item[] result = Arrays.copyOf(items, SHIFT);
        System.arraycopy(this.items, SHIFT, this.items,0 ,this.items.length - SHIFT);
    }

    /**
     * Получает список всех заявок.
     * @return
     */
    public Item[] findAll() {
        int count = 0;
        for (Item item : items) {
            if (item != null) {
                count++;
            }
        }
        Item[] result = new Item[count];
        int index = 0;
        do {
            for (this.position = 0; this.position != items.length; this.position++) {
                if (this.items[this.position] != null) {
                    result[index] = items[this.position];
                    index++;
                }
            }
        } while (index != count);
        return result;
    }

    /**
     * Получает список по имени.
     * @param name
     * @return
     */
    protected Item[] findByName(String name) {
        int count = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name) ) {
                count++;
            }
        }
        Item[] result = new Item[count];
        for (this.position = 0; this.position != this.items.length; this.position++) {
            for (int index = 0; index != count; index++) {
                if (this.items[index] != null && this.items[index].getName().equals(name)) {
                    result[index] = items[this.position];
                }
            }
        }
        return result;
    }

    /**
     * Ищет элемент по уникальному ключу для заявки.
     * @param id
     * @return
     */
    protected Item findById(String id) {
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
