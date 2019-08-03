package ru.job4j.sortuser;

import java.util.*;

public class ListExample {

    public static void main(String[] args) {
//        List<User> users = new ArrayList<User>();
        Set<User> users = new TreeSet<>();
        // простейшая реализация
//        users.add(new User("Max"));
        users.addAll(Arrays.asList(
                new User("Max", 34),
                new User("Timoha", 45),
                new User("Vera", 23),
                new User("Lev", 12)
                )
        );

        System.out.println(users);
    }
}
