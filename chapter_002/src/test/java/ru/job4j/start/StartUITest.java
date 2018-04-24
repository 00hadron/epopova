package ru.job4j.start;

import ru.job4j.tracker.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        String[] answers = {"0", "test name", "desc", "6"};
        Input input = new StubInput(answers);
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        String expected = "test name";
        assertThat(tracker.findAll()[0].getName(), is(expected));
    }

    @Test
    public void whenUserUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("pre name");
        tracker.add(item);
        String[] answer = {"2", item.getName(), "test name", "desc", "6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        String expected = "test name";
        assertThat(tracker.findById(item.getId()).getName(), is(expected));
    }

    @Test
    public void whenUserDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("name");
        tracker.add(item);
        String[] answer = {"3", item.getName(), "6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        String[] expected = {};
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenUserFindByIDThenTrackerHasRequestedValue() {
        Tracker tracker = new Tracker();
        Item one = new Item("one");
        Item two = new Item("two");
        Item three = new Item("three");
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        String[] answer = {"4", one.getId(), "6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        Item expected = one;
        assertThat( tracker.findAll()[0], is(expected));
    }

    @Test
    public void whenUserFindNameThenTrackerHasRequestedValue() {
        Tracker tracker = new Tracker();
        Item one = new Item("name");
        Item two = new Item("name");
        Item three = new Item("other name");
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        String[] answer = {"5", one.getName(), "6"};
        Input input = new StubInput(answer);
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        String expected = "name";
        assertThat( tracker.findAll()[0].getName(), is(expected));
    }
}
