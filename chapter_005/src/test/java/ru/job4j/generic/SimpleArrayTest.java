package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    @Test
    public void whenCreateStringArrayShouldReturnTheString() {
        StackArrayString simpleArray = new StackArrayString(20);
        simpleArray.add("test");
        simpleArray.add("test2");
        simpleArray.add("test3");
        simpleArray.add("test4");
        String result = (String) simpleArray.get(0);

        assertThat(result, is("test"));
    }

    @Test
    public void whenCreateIntegerArrayShouldReturnTheInteger() {
        StackArrayInteger simpleArray = new StackArrayInteger(20);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        Integer result = simpleArray.get(3);

        assertThat(result, is(4));
    }

    @Test
    public void whenSetNewStringArrayShouldReturnTheString() {
        SimpleArray simpleArray = new StackArrayString(40);
        simpleArray.add("test");
        simpleArray.set(0, "New test");
        String result = (String) simpleArray.get(0);

        assertThat(result, is("New test"));
    }

    @Test
    public void whenRemoveStringArray() {
        SimpleArray simpleArray = new StackArrayString(3);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        simpleArray.remove(0);

        String result = (String) simpleArray.get(0);
        assertThat(result, is("test2"));

        result = (String) simpleArray.get(1);
        assertThat(result, is("test3"));
    }

    @Test
    public void whenRemoveLastElement() {
        SimpleArray simpleArray = new StackArrayString(3);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        simpleArray.remove(3);

        String result = (String) simpleArray.get(0);
        assertThat(result, is("test1"));

        result = (String) simpleArray.get(1);
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
        SimpleArray simpleArray = new StackArrayString(40);
        simpleArray.add("test");
        Iterator it = simpleArray.iterator();
        String result = "";
        if (it.hasNext()) {
            result = (String) it.next();
        }

        assertThat(result, is("test"));
    }
}
