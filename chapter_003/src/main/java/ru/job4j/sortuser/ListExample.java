package ru.job4j.sortuser;

import java.util.*;

public class ListExample {

//    static class User {     // это сигнатура при листе
    static class User implements Comparable<User> {     // это сигнатура при сет. необходимо расширить от
        //интерфейчас Comparable
        private String name;    // имя пользователя
        private int age;        // возраст пользователя

        // онструктор
        User(String name, int age) {
            this.name = name;
            this.age = age;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return this.getAge() - o.getAge();
    }
}

    public ListExample() {
    }

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
