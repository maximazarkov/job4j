package ru.job4j.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<String> students) {
        Set<String> units = new HashSet<>();
        return students.stream()
//                .flatMap(String::lines)
                .collect(Collectors.toMap(p -> p, t -> units));
    }

    /*Данная функция эксперементальная и может быть @Deprecated*/
    public static Map<String, Integer> sections(List<String> students, Integer num) {
        return students.stream()
                .collect(Collectors.toMap(p1 -> p1, t -> num));
    }
}
