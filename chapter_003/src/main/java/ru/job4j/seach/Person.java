package ru.job4j.seach;
/**
 * Описание объектов, которые хранятся в справочнике.
 * Доступ к объектам.
 * @author epopova
 * @since 1.12.2018
 */

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}