package ru.job4j.profession;

/**
 * Класс Профессия.
 * @author epopova
 * @since 05.04.2018
 * @version $Id$
 */
public class Profession {
    private String name;
    private String profession;

    public Profession(String name, String profession)  {
        this.name = name;
        this.profession = profession;
    }

    public Profession() {

    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }
}
