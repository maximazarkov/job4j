package ru.job4j.list;

import java.util.Iterator;

public class SimpleStack<T>  {
    private int size; // размер контейнера
    private Node<T> head; // ссылка на первый объект харнения, который содержет ссылку на следующий элемент

    /**
     * Метод вставляет в начало списка данные.
     * Метод сдвигает все элементы вправо, при этом новый элемент добавляется слева
     * @param data - сохраняет
     */
    public void push(T data) {
        Node<T> newLink = new Node<>(data);  // создаем новый элемент
        newLink.prev = this.head; // запоминаем ссылку прежнего первого элемента в новом
        this.head = newLink; //
        this.size++;
    }

    public T poll() {
        T t = null;
        if (this.head != null) {
            t = this.head.data;    // запоминае элемент для вывода
            Node<T> next = this.head;      // созадем объект для выборки следующего элемента
            this.head = next.prev;         // смещаем ссылку первого элемента на следующий, при этом первый элемент уничтожается
        }
        size--;
        return t;
    }


    /**
     * Класс предназначен для хранения данных
     */
    private static class Node<E> {
        E data;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
        }
    }
}
