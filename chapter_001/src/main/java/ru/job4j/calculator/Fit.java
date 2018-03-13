package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 */
public class Fit {
    private static final double K_MAN = 100;
    private static final double K_WOMAN = 110;
    private static final double K_MULT  = 1.15;

    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double manWeight(double height) {
        return (height - K_MAN) * K_MULT;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    double womanWeight(double height) {
        return (height - K_WOMAN) * K_MULT;
    }
}