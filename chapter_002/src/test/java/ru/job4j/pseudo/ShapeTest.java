package ru.job4j.pseudo;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class ShapeTest {

    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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
        System.setOut(stdout);
    }
}
