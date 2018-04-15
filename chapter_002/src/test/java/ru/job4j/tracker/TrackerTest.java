package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item items = new Item("test1","testDescription",12345L);
        tracker.add(items);
        assertThat(tracker.findAll()[0], is(items));
    }
    @Test
    public void whenFindByNameThenResult() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);

        tracker.add(one);
        tracker.add(two);
        tracker.findByName("test2");
        assertThat(two.getName() , is("test2"));
    }

    @Test
    public void whenFindByNameThenTwoResult() {
        Tracker tracker = new Tracker();
        Item one = new Item("test2","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);
        tracker.add(one);
        tracker.add(two);
        tracker.findByName("test2");
        assertThat(two.getName() , is("test2"));
    }

    @Test
    public void whenFindByIdThenResult() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);
        tracker.add(one);
        tracker.add(two);
        assertThat( tracker.findById(two.getId()) , is(two));

    }

    @Test
    public void whenFindAllThenOneAndTwoResult() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);
        tracker.add(one);
        tracker.add(two);
        Item[] expected = {one, two};
        assertArrayEquals( expected, tracker.findAll());
    }


    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        tracker.add(next);
        String name = previous.getName();
        tracker.replace(previous.getId(), next);
        assertThat(name, is("test2"));
    }

    @Test
    public void whenDeleteThenNewItems() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);
        tracker.add(one);
        tracker.add(two);
        tracker.delete(one.getId());
        Item[] expected = {two};
        assertArrayEquals(expected, tracker.findAll());
    }

}


