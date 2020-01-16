package ru.job4j.generic;

import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Универсальная обертка над массивом. Структура массива не динамическая.
 * @param <T>
 */
public class SimpleArray<T> implements Iterator<T> {
    private int size;
    private int count = 0;
    private int it = 0;
//    private T[] array;   // Вариант ,если применять рефлексию
    private Object[] array;

    /**
     * @param size - количество ячеек
     */
    public SimpleArray(int size) {
        this.size = size;
        this.array = new Object[size]; //реализуем пока через Object, т.к. относительно понятно все
////        нужно попробовать реализовать все через рефлексию. Первая попытка была неудачной:
//        Class<T> t = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//
//        try {
////            T value = t.getDeclaredConstructor().newInstance();
////            System.out.print("string. " + value);
//            this.array = (T[]) t.getDeclaredConstructor().newInstance() ;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * добавляет указанный элемент (model) в первую свободную ячейку;
     * Если идет переполнение надо выкинуть ошибку.
     * @param model
     */
    public void add(T model) throws NullPointerException {
        if (count >= size) {
            throw new NullPointerException("Array is full");
        } else {
            this.array[count] = model;
            count++;
        }
    }

    /**
     * заменяет указанным элементом (model) элемент, находящийся по индексу index;
     * @param index
     * @param model
     */
    public void set(int index, T model) throws NullPointerException {
        if (index >= size) {
            throw new NullPointerException("index out of range ");
        } else {
        this.array[index] = model;
        count++;
        }
    }

    /**
     * удаляет элемент по указанному индексу, все находящиеся справа элементы при этом
     * необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);
     * @param index
     */
    public void remove(int index) {
        if (index >= size) {
            throw new NullPointerException("index out of range ");
        } else {
            this.array[index] = null;
            for (int i = index; i < size - 1; i++) {
                if (this.array[i + 1] == null) {
                    continue;
                }
                this.array[i] = this.array[i + 1];
            }
        }
    }

    /**
     * возвращает элемент, расположенный по указанному индексу;
     * @param index
     * @return
     */
    public T get(int index) throws NoSuchElementException {
        if (index >= size) {
            throw new NoSuchElementException("Index out of range Array");
        } else {
            return (T) this.array[index];
        }
    }

    @Override
    public boolean hasNext() {
        return  size > it;
    }

    @Override
    public T next() {
        return (T) this.array[it++];
    }
}