package ru.job4j.bank;

import java.util.*;

public class Sorter {

    public Sorter() {

    }

    /**
     * Сортировки списка пользователей
     * @param list список пользователей.
     * @return возвращает отсортированный список
     * @since 0.4 28.09.2021
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    /**
     * Сортировка пользователей по длине имени.
     * @param list список пользователей для сортировки
     * @return отсортированный список
     * @since 0.4 28.09.2021
     */
    private List<User> sortNmeLength(List<User> list) {
        Comparator<User> comparator = Comparator.comparingInt(o -> o.getUsername().length());
        list.sort(comparator);
        return list;
    }

    /**
     * Сортировка по двум признакам - имя, затем паспорт.
     * @param list список пользователей
     * @return список пользователей после сравнения
     * @since 0.4 28.09.2021
     */
    private List<User> sortBoth(List<User> list) {
        Comparator<User> c1 = Comparator.comparing(User::getUsername);
        Comparator<User> c2 = Comparator.comparing(User::getPassport);
        list.sort(c1.thenComparing(c2));
        return list;
    }
}