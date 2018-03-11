package ru.job4j.loop;

/**
 * Класс работает с псевдографикой.
 * @author epopova
 * @since 11.03.2018
 * @version $Id$
 */
public class Board {

    /**
     * Рисует шахматную доску.
     * @param width ширина доски.
     * @param height высота доски.
     * @return псевдографика.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++ ) {
            for (int j = 0; j < width; j++ ) {
                screen = (i+j) % 2 == 0? screen.append("X") : screen.append(" ");
            }
            screen.append(ln);
        }
        System.out.println(screen);
        return screen.toString();
    }
}


