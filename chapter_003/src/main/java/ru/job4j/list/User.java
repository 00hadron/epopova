package ru.job4j.list;
/**
 * Пользователи.
 * @author epopova
 * @since 10.12.2018
 */

public class User {
    private int id;
    private String name;
    private String city;

    public   User (int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }
}
