package ru.job4j.sort;

public class User implements Comparable<User> {
    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    User( int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    /**
     * Реализация интерфейса Comparable.
     * @param o
     * @return
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.getAge());
    }
}


