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
        int low = 0;
        int high = tasks.size() - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (tasks.get(mid).getPriority() == task.getPriority()) {
                break;
            }
            if (tasks.get(mid).getPriority() > task.getPriority()) {
                high = mid - 1;
            }
            if (tasks.get(mid).getPriority() < task.getPriority()) {
                low = mid + 1;
            }
        }
        if ((mid == high)) {
            tasks.add(mid + 1, task);
        } else {
            tasks.add(mid, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}