package ru.job4j.search;

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
        queue.put(new Task("mid", 5));
        queue.put(new Task("asdasd", 8));
        queue.put(new Task("affffffff", 7));
        queue.put(new Task("gggggg", 8));
        queue.put(new Task("uuuuuu", 5));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}