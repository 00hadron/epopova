package ru.job4j.profession;

/**
 * Класс Учитель наследник класса Профессия.
 * @author epopova
 * @since 05.04.2018
 * @version $Id$
 */
public class Teacher extends Profession {
    private String subject;

    public Teacher(String subject) {
        this.subject = subject;
    }

    /**
     * метод teach учит студента.
     * @param student
     */
    public void teach(Student student){

    }
}
