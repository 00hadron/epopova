package ru.job4j.seach;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriority2() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middle2", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle1", 3));
        queue.put(new Task("low", 8));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
        result = queue.take();
        assertThat(result.getDesc(), is("middle1"));
        result = queue.take();
        assertThat(result.getDesc(), is("middle2"));
        result = queue.take();
        assertThat(result.getDesc(), is("low"));
    }

    @Test
    public void whenTheSamePriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("1", 5));
        queue.put(new Task("2", 5));
        queue.put(new Task("3", 5));
        queue.take();
        queue.take();
        Task result = queue.take();
        assertThat(result.getDesc(), is("3"));
    }
}