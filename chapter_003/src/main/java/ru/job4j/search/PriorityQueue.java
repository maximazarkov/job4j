package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            for (int i = tasks.size() - 1; i >= 0; i--)
                if (tasks.get(i).getPriority() >= task.getPriority()) {
                    tasks.add(i, task);
                }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}