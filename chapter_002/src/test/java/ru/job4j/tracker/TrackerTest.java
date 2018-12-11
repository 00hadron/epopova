package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item items = new Item("test1","testDescription",12345L);
        tracker.add(items);
        Item result = tracker.findAll().get(0);
        Item expected = items;
        assertThat(result, is(expected));
    }
    @Test
    public void whenFindByNameThenResult() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);
        tracker.add(one);
        tracker.add(two);
        List<Item> result = tracker.findByName("test2");
        Item[] expected = {two};
        assertThat(result.toArray() , is(expected));
    }

    @Test
    public void whenFindByNameThenTwoResult() {
        Tracker tracker = new Tracker();
        Item one = new Item("test2","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);
        Item three = new Item("test3","testDescription3",12346L);
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        List<Item> result = tracker.findByName("test2");
        Item[] expected = {one, two};
        assertThat(result.toArray() , is(expected));
    }

    @Test
    public void whenFindByIdThenResult() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);
        tracker.add(one);
        tracker.add(two);
        Item result = tracker.findById(two.getId());
        Item expected = two;
        assertThat( result , is(expected));
    }

    @Test
    public void whenFindAllThenOneAndTwoResult() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);
        tracker.add(one);
        tracker.add(two);
        List<Item> result = tracker.findAll();
        Item[] expected = {one, two};
        assertThat(result.toArray(), is(expected));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        Item next = new Item("test2","testDescription2",1234L);
        tracker.add(previous);
        tracker.add(next);
        String id = previous.getId();
        tracker.replace(id, next);
        Item result = tracker.findById(next.getId());
        assertThat(result.getName(), is(next.getName()));
    }

    @Test
    public void whenDeleteThenNewItems() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1","testDescription",12345L);
        Item two = new Item("test2","testDescription2",1234L);
        Item three = new Item("test3","testDescription3",12346L);
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        tracker.delete(two.getId());
        Item[] expected = {one, three};
        List<Item> result = tracker.findAll();
        assertThat(result.toArray(), is(expected));
    }
}