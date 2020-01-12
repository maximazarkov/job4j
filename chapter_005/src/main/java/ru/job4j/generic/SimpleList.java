package ru.job4j.generic;

import java.lang.reflect.ParameterizedType;

/**
 * TODO: comment
 * @param <E>
 */
//public class SimpleList<E extends Number> {
public class SimpleList<E> {

    Object[] objects;
    int index = 0;

    // прогамма не качественная, только для демонстрации
    public <T> SimpleList(int size) {
        this.objects = new Object[size];
        Class<T> t = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments() [0];
        try {
            T value = t.newInstance();
            System.out.printf("string. " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <K> K print(K value) {
        System.out.println(value);
        return value;
    }

    public void add(E value) {
        this.objects[index++] = value;
    }

    public E get(int posirion) {
        return (E) this.objects[posirion];
    }
}
