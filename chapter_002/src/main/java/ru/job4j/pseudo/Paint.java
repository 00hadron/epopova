package ru.job4j.pseudo;

/**
 * "Strategy" pattern.
 * Paint (Context) class.
 * @author epopova
 */

public class Paint {
    private Shape shape;

    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * Вывести фигуру в консоль.
     */
    public void draw() {
        System.out.println(this.shape.draw());
    }
}
