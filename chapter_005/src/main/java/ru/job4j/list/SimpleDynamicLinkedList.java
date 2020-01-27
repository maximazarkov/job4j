package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleDynamicLinkedList<E> implements SimpleContainer<E> {
    private int size = 0;
    private int modCount = 0;

    /**
     * Pointer to first node.
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     */
    transient Node<E> last;

    public SimpleDynamicLinkedList() {
    }

    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;

    }

    @Override
    public E get(int index) {
        E r = null;
        if (index < size) {
            if (this.first != null) {
                Node<E> result = this.first;
                for (int i = 0; i < index; i++) {
                    result = result.next;
                }
                r = result.item;
            }
        }
        return r;
    }


    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int mc = modCount;
            int it = 0;
            @Override
            public boolean hasNext() {
                if (modCount != mc) {
                    throw new ConcurrentModificationException();
                }
                return  size > it;
            }

            @Override
            public E next() {
                return (E) get(it++);
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }
}
