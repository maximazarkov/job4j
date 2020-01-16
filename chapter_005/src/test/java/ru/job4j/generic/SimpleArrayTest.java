package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    @Test
    public void whenCreateStringArrayShouldReturnTheString() {
        SimpleArray simpleArray = new StackArray(40);
        simpleArray.add("test");
        String result = (String) simpleArray.get(0);

        assertThat(result, is("test"));
    }

    @Test
    public void whenSetNewStringArrayShouldReturnTheString() {
        SimpleArray simpleArray = new StackArray(40);
        simpleArray.add("test");
        simpleArray.set(0, "New test");
        String result = (String) simpleArray.get(0);

        assertThat(result, is("New test"));
    }

    @Test
    public void whenRemoveStringArray() {
        SimpleArray simpleArray = new StackArray(40);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        simpleArray.remove(0);
        String result = (String) simpleArray.get(0);

        assertThat(result, is("test2"));
    }

//    @Test
//    public void whenIteratorStringArray() {
//        SimpleArray simpleArray = new StackArray(40);
//        simpleArray.add("test");
//        String result = "";
//        if (simpleArray.hasNext()) {
//            result = (String) simpleArray.next();
//        }

//        assertThat(result, is("test"));
//    }

    @Test
    public void whenIterableStringArray() {
        SimpleArray simpleArray = new StackArray(40);
        simpleArray.add("test");
        Iterator it = simpleArray.iterator();
        String result = "";
        if (it.hasNext()) {
            result = (String) it.next();
        }

        assertThat(result, is("test"));
    }
}
