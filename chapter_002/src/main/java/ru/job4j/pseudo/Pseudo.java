package ru.job4j.pseudo;

/**
 * "Strategy" pattern demonstration.
 * Use the Paint (Context)  to see change in behaviour when it changes its Strategy
 * @author epopova
 */
public class Pseudo {
    public static void main(String[] args) {
        Paint paint = new Paint(new Triangle());
        paint.draw();
        paint = new Paint(new Square());
        paint.draw();
    }
}
