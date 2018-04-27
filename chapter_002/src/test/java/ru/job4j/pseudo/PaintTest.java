package ru.job4j.pseudo;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenDrawSquare() {
        Paint paint = new Paint(new Square());
        paint.draw();
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++\n");
        pic.append("+     +\n");
        pic.append("+     +\n");
        pic.append("+++++++\n");
        pic.append(System.lineSeparator());
        String expected = pic.toString();
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenDrawTriangle() {
        Paint paint = new Paint(new Triangle());
        paint.draw();
        StringBuilder pic = new StringBuilder();
        pic.append("   +\n");
        pic.append("  + +\n");
        pic.append(" +   +\n");
        pic.append("+++++++\n");
        pic.append(System.lineSeparator());
        String expected = pic.toString();
        assertThat(new String(out.toByteArray()), is(expected));
    }
}
