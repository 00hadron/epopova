package ru.job4j.pseudo;

/**
 * Треугольник.
 * Create concrete classes implementing the same interface
 * @author epopova
 */

public class Triangle implements Shape {

    /**
     * Рисует треугольник.
     * @return фигуру в виде строки
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +\n");
        pic.append("  + +\n");
        pic.append(" +   +\n");
        pic.append("+++++++\n");
        return pic.toString();
    }
}
