package ru.job4j.lite;

import java.util.*;
import java.util.function.Consumer;

public class ListExample {

//    static class User {     // это сигнатура при листе
    static class User implements Comparable<User> {     // это сигнатура при сет. необходимо расширить от
        //интерфейчас Comparible
        private final String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + '}';
        }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
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
                new User("Max"),
                new User("Timoha"),
                new User("Vera"),
                new User("Lev")
                )
        );

        System.out.println(users);

        //сортировка применяется в листе
        //в set сортировки нет
//        users.sort(
//                new Comparator<User>() {
//                    @Override
//                    public int compare(User o1, User o2) {
//                        return o1.name.compareTo(o2.name);
//                    }
//                }
//        );
//
//        System.out.println(users);
    }

}
