package ru.job4j.list;

import java.util.Iterator;

public class Node<T> implements Iterator {
    private T value;
    private Node <T> next;

    public Node(T value) {
//        this.next = (value == size) ? null : (Node<E>) node(index);
//        this.value = value;
// = index;

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
