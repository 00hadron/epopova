package ru.job4j.loop;

/**
 * Класс работает с псевдографикой.
 * @author epopova
 * @since 12.03.2018
 * @version $Id$
 */
public class Paint {

    /**
     * Прорисовка правой стороны пирамиды в псевдографике.
     * @param height высота пирамиды.
     * @return screen.
     */
    public String rightTrl (int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column !=weight; column++){
                screen = row >=column? screen.append("^") : screen.append(" ");
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Прорисовка левой стороны пирамиды в псевдографике.
     * @param height высота пирамиды.
     * @return screen.
     */
    public String leftTrl (int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column !=weight; column++){
                screen = row >= (weight - column - 1)? screen.append("^") : screen.append(" ");
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }


    /**
     * Прорисовка полной пирамиды в псевдографике.
     * @param height высота пирамиды.
     * @return screen.
     */
    public String piramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                screen = row >= (height - column - 1) && (row + height - 1 >= column) ?
                        screen.append("^") : screen.append(" ");
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
