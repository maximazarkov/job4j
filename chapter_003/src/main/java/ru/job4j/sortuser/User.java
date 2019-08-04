package ru.job4j.sortuser;

import java.util.Objects;

//    public class User {     // это сигнатура при листе
public class User implements Comparable<User> { // это сигнатура при сет. необходимо расширить от
    //интерфейчас Comparable
    private String name;    // имя пользователя
    private int age;        // возраст пользователя

    // конструктор
    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == ((User) o).age &&
                Objects.equals(name, ((User) o).name);
    }

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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

}


