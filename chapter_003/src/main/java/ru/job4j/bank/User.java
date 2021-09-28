package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Azarkov Maxim.
 * @since 0.4 10.09.2019
 */
public class User implements Comparable<User> {
    private String name;
    private String passport;

    public User() {
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Переопределенный метод интерфейса Comparable для выполнения базовой сортировки
     * @param o - передаваемый объект
     * @return - результат сравнения возрастов
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", passport=" + passport
                + '}';
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User user) {
        return this.passport.compareTo(user.passport);
    }
}