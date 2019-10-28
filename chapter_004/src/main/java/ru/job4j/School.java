package ru.job4j;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * преобразование списка в карту, с применением stream...Collectors.toMap.
     * @param students - список студентов.
     * @param predictKey - фамилия ученика.
     * @param predictValue объект ученика.
     * @return - список студентов (Map).
     * @since v0.4 28.10.2019.
     */
    public Map<String, Student> collect(List<Student> students,
                                        Function<Student, String> predictKey,
                                        Function<Student, Student> predictValue) {
        return students.stream()
                .collect(Collectors.toMap(predictKey, predictValue));
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .takeWhile(b -> b.getScope() >= bound)
                .collect(Collectors.toList());
    }

}