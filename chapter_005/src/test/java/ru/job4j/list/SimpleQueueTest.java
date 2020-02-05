package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    @Test
    public void wherePushAndPoll() {
        SimpleQueue<String> sss = new SimpleQueue<>();
        sss.push("one");
        sss.push("two");
        sss.push("three");
        assertThat(sss.poll(), is("one"));
        assertThat(sss.poll(), is("two"));
        assertThat(sss.poll(), is("three"));
    }
}