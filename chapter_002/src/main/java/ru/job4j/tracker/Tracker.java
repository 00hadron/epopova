package ru.job4j.tracker;

import java.util.*;

/**
 * Класс хранит и обрабатывает заявки.
 * (Все массивы заменены на List)
 * @version 0.2
 * @since 11.12.2018
 */
public class Tracker {

    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * Добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Редактирование заявок.
     * @param id заменяемого элемента массива.
     * @param item - эти данные перезаписать в заменяемый элемент массива.
     * */
    public void replace(String id, Item item) {
        items.set(items.indexOf(findById(id)), item);
    }

    /**
     * удаляет заявку.
     * @param id
     */
    public void delete(String id) {
        items.remove(findById(id));
    }

    /**
     * Получает список всех заявок.
     * @return
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Получает список по имени.
     * @param name
     * @return
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item element : items) {
            if (element.getName().equals(name)) {
                result.add(element);
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
            if (element.getId().equals(id)) {
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
