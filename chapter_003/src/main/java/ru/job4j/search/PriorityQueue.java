package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        var low = 0;
        var high = tasks.size() - 1;
        var mid = 0;
        ListIterator<Task> lit;
        while (low <= high) {
            mid = (low + high) / 2;
            lit = tasks.listIterator(mid);
            var tsksPriority = lit.next().getPriority();
            var tskPriority = task.getPriority();
            if (tsksPriority == tskPriority) {
                break;
            }
            if (tsksPriority > tskPriority) {
                high = mid - 1;
            }
            if (tsksPriority < tskPriority) {
                low = mid + 1;
            }
        }
        if ((mid == high)) {
            lit = tasks.listIterator(mid + 1);
            lit.add(task);
        } else {
            lit = tasks.listIterator(mid);
            lit.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}