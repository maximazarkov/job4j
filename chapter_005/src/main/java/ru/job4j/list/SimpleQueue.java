package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleDynamicLinkedList<T> sdll;

    public SimpleQueue() {
        this.sdll = new SimpleDynamicLinkedList<>();
    }

    public T poll() {
        return (T) sdll.removeFirst();
    }

    public void push(T value) {
        sdll.add(value);
    }
}
