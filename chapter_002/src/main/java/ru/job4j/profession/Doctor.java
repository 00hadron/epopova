package ru.job4j.profession;

/**
 * Класс Доктор наследник класса Профессия.
 * @author epopova
 * @since 05.04.2018
 * @version $Id$
 */
public class Doctor extends Profession {

    private String degree;

    public Doctor(String degree) {
        this.degree = degree;
    }

    /**
     * Поставить диагноз.
     * @param patient
     */
    public void diagnose(Patient patient){

    }

    /**
     * лечить пациента.
     * @param patient
     */
    public void treat(Patient patient){

    }


}
