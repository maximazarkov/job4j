package ru.job4j;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 */
public class School {
    /**
     *
     * @param students - список студентов
     * @param predict - параметр отбора в определенный класс, формат - лямбда выражение
     * @return список студентов, прошедших отбор
     * @since v0.2 16.10.2019
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}