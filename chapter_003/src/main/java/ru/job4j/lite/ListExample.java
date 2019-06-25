package ru.job4j.lite;

import java.util.*;
import java.util.function.Consumer;

public class ListExample {

    static class User {
        private final String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        // простейшая реализация
//        users.add(new User("Max"));
        users.addAll(Arrays.asList(new User("Max"), new User("Timoha")));
//        boolean result = users.contains(new User("Max"));
//        System.out.println(result);

        // реализация с помощью циклов
//        for (User user: users) {
//            System.out.println(user);
//        }

        // реализация с помощью итератора
//        Iterator<User> it = users.iterator();
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }

        // реализация с помощью стрим апи
        users.forEach(
                new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        System.out.println(user);
                    }
                }
        );

        // упростим стрми апи до лямбда
        users.forEach(user -> System.out.println(user));

        // еще вариант упрощения. статический вызов не статического поля у обьъекта
        users.forEach(System.out::println);
    }

}
