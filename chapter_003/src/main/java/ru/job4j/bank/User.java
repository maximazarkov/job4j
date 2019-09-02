package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Azarkov Maxim.
 * @since 21.08.2019
 */
public class User {
    private String name;    // имя пользователя
    private String pasport; // данные поспорта

    public User() {
    }

    public User(String name, String pasport) {
        this.name = name;
        this.pasport = pasport;
    }

    /**
     * Переопределенный метод интерфейса Comparable для выполнения базовой сортировки
     * @param o - передаваемый объект
     * @return - результат ставнения возрастов
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(pasport, user.pasport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pasport);
    }

    public String getPassport() {
        return pasport;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", pasport=" + pasport
                + '}';
    }

    public String getName() {
        return name;
    }

}