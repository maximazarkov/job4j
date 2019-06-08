package ru.job4j.videointro;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("petr arsentev", 3);
        students.put("ivanov ivan", 5);

        System.out.println(students.get("petr arsentev"));

        students.put("petr arsentev", 10);
        for (String student : students.keySet()) {
            System.out.println(String.format("%s : %s", student, students.get(student)));
        }

        for (Integer scope : students.values()) {
            System.out.println(String.format("%s", scope));
        }

    }
}
