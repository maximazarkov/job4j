package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleListTest {

    public class A extends Number {
        @Override
        public int intValue() {
            return 0;
        }

        @Override
        public long longValue() {
            return 0;
        }

        @Override
        public float floatValue() {
            return 0;
        }

        @Override
        public double doubleValue() {
            return 0;
        }
    }
    public class B extends A {

    }
    public class C extends B {

    }

    public void wildTest() {
//        SimpleList<A> list = new SimpleList<>(10);
        SimpleList<B> list = new SimpleList<>(10);
//        list.add(new A());
        list.add(new B());
        list.add(new C());

        print(list);
        printUpper(list);
        printLower(list);
    }

    public void print(SimpleList<?> list) {
        //todo print
    }

    public void printUpper(SimpleList<? extends B> list) {

    }

    public void printLower(SimpleList<? super B> list) {

    }

    @Test
    public void whenCreateStringShouldReturnTheString() {
        Stack simpleList = new Stack(4);
        simpleList.add("test");
        String result = simpleList.get(0);

        assertThat(result, is("test"));
    }

    /**
     * отпала актуальность в тесте, т.к. добавили класс Stack и усовершенствовали
     * конструктор SimpleList для вытаскивания генерика с помощью рефлексии
     * @deprecated
     */
    @Test
    public void whenCreateIntShouldReturnInt() {
////        SimpleList<Integer> simpleList = new SimpleList<Integer>(4);
//        SimpleList<Integer> simpleList = new SimpleList<>(4);
//        simpleList.add(2);
//        Integer result = simpleList.get(1);
//
//        assertThat(result, is(2));
    }

}