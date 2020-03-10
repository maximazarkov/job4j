package ru.job4j.generic;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleList<E> sl;
    private int modCount = 0;
    private int count = 0;
    private int size;

    public SimpleSet(int size) {
        this.sl = new SimpleList<>(size);
//        this.size = (size < 2) ?  10 :  size;
        this.size = size;
    }

    private void checkForResize() {
        if (this.count >= this.size) {
            this.size = size + 10;
            SimpleList<E> newSl = new SimpleList<>(this.size);
            Iterator<E> it = this.iterator();
            while (it.hasNext()) {
                newSl.add(it.next());
            }
            this.sl = newSl;
        }
    }

    public void add(E value) {
        checkForResize();
        if (!contains(value)) {
            sl.add(value);
            modCount++;
            count++;
        }
    }

    public boolean contains(E value) {
        boolean result = false;
        if (value == null) {
            result = true;
        } else {
            Iterator<E> cont = this.iterator();
            while (cont.hasNext()) {
                if (cont.next().equals(value)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public int size() {
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
                    new ConcurrentModificationException();
                }
                return count > it;
            }

            @Override
            public E next() {
                return (E) sl.get(it++);
            }
        };
    }
}
