package ru.job4j;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", spent=" + spent +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );
        List<Task> bugs = tasks.stream().filter(    // получаем объект типа Stream  и выполняе метод filter, который принимае лямбда выражение Predicate<Task>
                task -> task.name.contains("Bug")   // задаем условие, что пропускать только те  задачи, которые содержат слово Bug.
        ).collect(Collectors.toList());             // полученные результаты сохраняем в коллекции типа List.
        bugs.forEach(System.out::println);

        // Допустим, что на нужно получить только имена задач. Для этого нужно применить метод map.
        List<String> names = tasks.stream().map(
                task -> task.name
        ).collect(Collectors.toList());
        names.forEach(System.out::println);

        // Давайте теперь посчитаем общую сумму потраченную на все задачи.
        long total = tasks.stream().map(
                task -> task.spent
        ).reduce(0L, Long::sum);   //каждое значение task.spent - нужно сложить с начальным значение 0L.

        System.out.println(total);
    }
}