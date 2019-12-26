package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Converter<T> implements Iterator<T> {
    private Iterator<Iterator<T>> iters;
    private Iterator<T> itInt;

    @Override
    public boolean hasNext() {
        return itInt != null;
    }

    @Override
    public T next() throws NoSuchElementException {
        T t = itInt.next();

        while (itInt != null && !itInt.hasNext()) {
            itInt = this.iters.hasNext() ? this.iters.next() : null;
        }

        return t;
    }

    Iterator<Integer> convert(Iterator<T>... iters) {
        this.iters = Arrays.asList(iters).iterator();
        itInt = this.iters.hasNext() ? this.iters.hasNext() : null;

        Iterator<Integer> result = null;
        return result;
    }

    @Override
    public void forEachRemaining(Consumer action) throws NullPointerException {
        while (hasNext())
            action.accept(next());
    }
}
