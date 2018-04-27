package ru.job4j.pseudo;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PseudoTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++\n");
        pic.append("+     +\n");
        pic.append("+     +\n");
        pic.append("+++++++\n");
       // pic.append(System.lineSeparator());
        String expected = pic.toString();
        assertThat(square.draw(), is(expected));
    }
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        StringBuilder pic = new StringBuilder();
        pic.append("   +");
        pic.append("  + +");
        pic.append(" +   +");
        pic.append("+++++++");
       // pic.append(System.lineSeparator());
        String expected = pic.toString();
        assertThat(triangle.draw(), is(expected));
    }
}
