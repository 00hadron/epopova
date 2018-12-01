package ru.job4j.seach;
/**
 * Обработка данных в справочнике.
 * @author epopova
 * @since 1.12.2018
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();
    private List<Person> result = new LinkedList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {

        for (Person person : persons)
            if(person.getName().contains(key) ||
                    person.getSurname().contains(key) ||
                    person.getAddress().contains(key) ||
                    person.getPhone().contains(key)) {
                this.result.add(person);
            }
        return result;
    }
}