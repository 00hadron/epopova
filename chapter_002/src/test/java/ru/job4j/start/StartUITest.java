package ru.job4j.start;

import ru.job4j.tracker.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    private final Tracker tracker = new Tracker();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        String[] answers = {"0", "test name", "desc", "6"};
        Input input = new StubInput(answers);
        StartUI startUI = new StartUI(input, this.tracker);
        startUI.init();
        String expected = "test name";
        assertThat(this.tracker.findAll()[0].getName(), is(expected));
    }

    @Test
    public void whenUserUpdateThenTrackerHasUpdatedValue() {
        Item item = new Item("pre name");
        this.tracker.add(item);
        String[] answer = {"2", item.getName(), "test name", "desc", "6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, this.tracker);
        startUI.init();
        String expected = "test name";
        assertThat(this.tracker.findById(item.getId()).getName(), is(expected));
    }

    @Test
    public void whenUserDeleteThenTrackerHasDeletedValue() {
        Item item = new Item("name");
        this.tracker.add(item);
        String[] answer = {"3", item.getName(), "6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, this.tracker);
        startUI.init();
        String[] expected = {};
        assertThat(this.tracker.findAll(), is(expected));
    }

    @Test
    public void whenUserFindByIDThenTrackerHasRequestedValue() {
        Item one = new Item("one");
        Item two = new Item("two");
        Item three = new Item("three");
        this.tracker.add(one);
        this.tracker.add(two);
        this.tracker.add(three);
        String[] answer = {"4", one.getId(), "6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, this.tracker);
        startUI.init();
        Item expected = one;
        assertThat(this.tracker.findAll()[0], is(expected));
    }

    @Test
    public void whenUserFindNameThenTrackerHasRequestedValue() {
        Item one = new Item("name");
        Item two = new Item("name");
        Item three = new Item("other name");
        this.tracker.add(one);
        this.tracker.add(two);
        this.tracker.add(three);
        String[] answer = {"5", one.getName(), "6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, this.tracker);
        startUI.init();
        String expected = "name";
        assertThat(this.tracker.findAll()[0].getName(), is(expected));
    }

    @Test
    public void whenUserChooseShowAllItemsThenShowAllOnScreen() {
        this.loadOutput();
        Item one = new Item("one");
        Item two = new Item("two");
        Item three = new Item("three");
        this.tracker.add(one);
        this.tracker.add(two);
        this.tracker.add(three);
        String[] answer = {"1", "6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, this.tracker);
        startUI.init();
        String result = new String(out.toByteArray());
        String expected =
                "        Menu\n "
                        + "     0. Add new Item\n"
                        + "     1. Show all items\n"
                        + "     2. Edit item\n"
                        + "     3. Delete item\n"
                        + "     4. Find item by Id\n"
                        + "     5. Find items by name\n"
                        + "     6. Exit Program\n\r\n"
                        + ""
                + "--- Сейчас покажу все items... ---\r\n"
                + "1. name one; desc null\r\n"
                + "2. name two; desc null\r\n"
                + "3. name three; desc null\r\n"
                + "        Menu\n "
                + "     0. Add new Item\n"
                + "     1. Show all items\n"
                + "     2. Edit item\n"
                + "     3. Delete item\n"
                + "     4. Find item by Id\n"
                + "     5. Find items by name\n"
                + "     6. Exit Program\n\r\n";
        assertThat(result, is(expected));
        this.backOutput();
    }

    @Test
    public void whenUserChooseExitThenExitOnScreen() {
        this.loadOutput();
        String[] answer = {"6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, this.tracker);
        startUI.init();
        String result = new String(out.toByteArray());
        String expected =
                "        Menu\n "
                        + "     0. Add new Item\n"
                        + "     1. Show all items\n"
                        + "     2. Edit item\n"
                        + "     3. Delete item\n"
                        + "     4. Find item by Id\n"
                        + "     5. Find items by name\n"
                        + "     6. Exit Program\n\r\n";
        assertThat(result, is(expected));
        this.backOutput();
    }
}
