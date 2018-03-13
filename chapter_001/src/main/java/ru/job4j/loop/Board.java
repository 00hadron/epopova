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
     *
     * @param width  ширина доски.
     * @param height высота доски.
     * @return псевдографика.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int colomn = 0; colomn < height; colomn++) {
            for (int row = 0; row < width; row++) {
                if ((colomn + row) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}


