package ru.job4j.pseudo;

/**
 * Квадрат.
 * Create concrete classes implementing the same interface
 * @author epopova
 */

public class Square implements Shape {

    /**
     * Рисует квадрат.
     * @return фигуру в виде строки
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++\n");
        pic.append("+     +\n");
        pic.append("+     +\n");
        pic.append("+++++++\n");
        return pic.toString();
    }
}
