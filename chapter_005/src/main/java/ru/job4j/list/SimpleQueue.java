package ru.job4j.list;

import java.util.Iterator;
import java.util.Stack;

/**
 * Нужно реализовать очередь.
 *
 * public class SimpleQueue<T> {
 *    public <T> poll()
 *
 *    public void push(T value);
 * }
 *
 * Метод poll() - должен возвращать значение и удалять его из коллекции.
 * Метод push(T value) - помещает значение в коллекцию.
 *
 * Внутри очереди нужно использовать Стеки из задания 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack
 *
 * Описание Queue - очередь. Описывается FIFO - first input first output.
 *
 * То есть, первый зашел и первый вышел. Например.
 *
 * push(1);
 * push(2);
 * push(3);
 *
 * poll() - 1
 * poll() - 2
 * poll() - 3
 *
 * Это задание является тестовым заданием на собеседованиях.
 * @param <T>
 */
public class SimpleQueue<T> {
    private SimpleDynamicLinkedList<T> sdllIn = new SimpleDynamicLinkedList<>();
    private SimpleDynamicLinkedList<T> sdllOut = new SimpleDynamicLinkedList<>();

    /**
     * метод, прежде чем извлечь элемент, делать "переворот" второй коллекции путем сохранения ее в первой коллекции.
     * После пермещения первый введенный элемент оказываетс на вершине стека - коллекции, но и удаляется по LIFO, т.к.
     * считается,что они пришел последним. Благодяря данным переворотам получается эффект FIFO.
     * @return
     */
    public T poll() {
        pushStackToStack(sdllOut, sdllIn);
        return (T) sdllIn.removeLast();
    }

    /**
     * метод, прежде чем сохранить элемент, делать "переворот" первой коллекции путем сохранения ее во второй коллекции,
     * но при этом последний - новый элемент всегда остается в первой коллекции.
     * @param value - единственный элемент, который будет сохранен в первой коллекции, и перемещен во вторую при
     *              добавлении следующего элемента
     */
    public void push(T value) {
        pushStackToStack(sdllIn, sdllOut);
        sdllIn.add(value);
    }

    /**
     * Данные метод осуществляет перенос данных из одной коллекции в другую для осуществелния переворота
     * в зависимости от того, добавляются данные из стека или извлекаются источники могут менятся местами
     * @see #push
     * @see #poll
     * @param from - коллекция, откуда нужно выполнить перенос данных
     * @param to - коллекция, в которую нужно перенести данные
     */
    private void pushStackToStack(SimpleDynamicLinkedList<T> from, SimpleDynamicLinkedList<T> to) {
        Iterator<T> it = from.iterator(0);
        while (it.hasNext()) {
            to.add(from.removeLast());
        }
    }
}
