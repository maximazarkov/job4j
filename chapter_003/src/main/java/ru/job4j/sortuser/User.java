package ru.job4j.sortuser;

import java.util.*;

/**
 * @author Azarkov Maxim.
 * @since 04.08.2019
 */
public class User implements Comparable<User> {
    private String name;    // имя пользователя
    private int age;        // возраст пользователя

    User(String name, int age) {
        this.name = name;
        this.age = age;
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
        return age == ((User) o).age
                && Objects.equals(name, ((User) o).name);
    }

    /**
     * Переопределенный метод интерфейса Comparable для выполнения базовой сортировки
     * @param o - передаваемый объект
     * @return - результат ставнения возрастов
     */
    @Override
    public int compareTo(User o) {
        return this.getAge() - o.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}


